package com.bytedance.android.livesdk.live.provider;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.gson.EmptyResponseInstanceCreator;
import com.bytedance.android.live.network.gson.ExtraResponseInstanceCreator;
import com.bytedance.android.live.network.gson.SimpleResponseInstanceCreator;
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.network.response.ListResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.service.k;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class GsonProvider implements k.b<Gson> {

    public static abstract class AbsJsonDeserializer<T> implements JsonDeserializer<T> {
        public final Gson a;

        public AbsJsonDeserializer(Gson r1) {
            this.a = r1;
        }
    }

    public static class BaseListResponseDeserializer extends AbsJsonDeserializer<BaseListResponse> {
        public BaseListResponseDeserializer(Gson r1) {
            super(r1);
        }

        public final Object deserialize(JsonElement r4, Type r5, JsonDeserializationContext r6) throws JsonParseException {
            JsonObject r7 = r4.getAsJsonObject();
            if (r7.get("status_code") == null) goto L5;
            int r0 = r7.get("status_code").getAsInt();
        L6:
            if (r0 == 0) goto L16;
            BaseListResponse r8 = new BaseListResponse();
            r8.statusCode = r0;
            r8.error = (RequestError) GsonProtectorUtils.fromJson(this.a, r7.get("data"), RequestError.class);
            if ((r5 instanceof ParameterizedType) == false) goto L14;
            Type[] r9 = ((ParameterizedType) r5).getActualTypeArguments();
            if (r9.length > 1) goto L13;
            r8.extra = (Extra) GsonProtectorUtils.fromJson(this.a, r7.get("extra"), Extra.class);
            return r8;
        L13:
            r8.extra = (Extra) GsonProtectorUtils.fromJson(this.a, r7.get("extra"), r9[1]);
            return r8;
        L14:
            r8.extra = (Extra) GsonProtectorUtils.fromJson(this.a, r7.get("extra"), Extra.class);
            return r8;
        L16:
            return (BaseListResponse) GsonProtectorUtils.fromJson(this.a, r4, r5);
        L5:
            r0 = 0;
            goto L6
        }
    }

    public static class BaseResponseDeserializer extends AbsJsonDeserializer<BaseResponse> {
        public BaseResponseDeserializer(Gson r1) {
            super(r1);
        }

        public final Object deserialize(JsonElement r2, Type r3, JsonDeserializationContext r4) throws JsonParseException {
            BaseResponse r5 = (BaseResponse) GsonProtectorUtils.fromJson(this.a, r2, r3);
            if (r5.statusCode == 0) goto L5;
            r5.error = (RequestError) GsonProtectorUtils.fromJson(this.a, r2.getAsJsonObject().get("data"), RequestError.class);
        L5:
            return r5;
        }
    }

    public static class BooleanTypeAdapter extends TypeAdapter<Boolean> {
        private BooleanTypeAdapter() {
        }

        public /* synthetic */ BooleanTypeAdapter(int r1) {
            this();
        }

        public final Object read(JsonReader r5) throws IOException {
            JsonToken r0 = r5.peek();
            int r1 = a.a[r0.ordinal()];
            boolean r2 = true;
            if (r1 == 1) goto L17;
            if (r1 != 2) goto L7;
            r5.nextNull();
            return null;
        L7:
            if (r1 != 3) goto L14;
            if (r5.nextInt() != 0) goto L18;
            r2 = false;
        L18:
            return Boolean.valueOf(r2);
        L14:
            throw new JsonParseException("Expected BOOLEAN or NUMBER but was " + r0);
        L17:
            return Boolean.valueOf(r5.nextBoolean());
        }

        public final void write(JsonWriter r1, Object r2) throws IOException {
            Boolean r3 = (Boolean) r2;
            if (r3 != null) goto L5;
            r1.nullValue();
            return;
        L5:
            r1.value(r3);
        }
    }

    public static class ListResponseDeserializer extends AbsJsonDeserializer<ListResponse> {
        public ListResponseDeserializer(Gson r1) {
            super(r1);
        }

        public final Object deserialize(JsonElement r3, Type r4, JsonDeserializationContext r5) throws JsonParseException {
            JsonObject r6 = r3.getAsJsonObject();
            int r0 = r6.get("status_code").getAsInt();
            if (r0 == 0) goto L7;
            ListResponse r7 = new ListResponse();
            ((BaseListResponse) r7).statusCode = r0;
            ((BaseListResponse) r7).extra = (Extra) GsonProtectorUtils.fromJson(this.a, r6.get("extra"), Extra.class);
            ((BaseListResponse) r7).error = (RequestError) GsonProtectorUtils.fromJson(this.a, r6.get("data"), RequestError.class);
            return r7;
        L7:
            return (ListResponse) GsonProtectorUtils.fromJson(this.a, r3, r4);
        }
    }

    public static class ResponseDeserializer extends AbsJsonDeserializer<Response> {
        public ResponseDeserializer(Gson r1) {
            super(r1);
        }

        public final Object deserialize(JsonElement r2, Type r3, JsonDeserializationContext r4) throws JsonParseException {
            Response r5 = (Response) GsonProtectorUtils.fromJson(this.a, r2, r3);
            if (((BaseResponse) r5).statusCode == 0) goto L5;
            ((BaseResponse) r5).error = (RequestError) GsonProtectorUtils.fromJson(this.a, r2.getAsJsonObject().get("data"), RequestError.class);
        L5:
            return r5;
        }
    }

    public static class RoomDeserializer implements JsonDeserializer<Room> {
        public final Gson a;

        private RoomDeserializer() {
            this.a = GsonHelper.get();
        }

        public /* synthetic */ RoomDeserializer(int r1) {
            this();
        }

        public final Object deserialize(JsonElement r1, Type r2, JsonDeserializationContext r3) throws JsonParseException {
            Room r4 = (Room) GsonProtectorUtils.fromJson(this.a, r1, r2);
            r4.init();
            return r4;
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[JsonToken.values().length];
            a = r0;
            r0[JsonToken.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[JsonToken.NULL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[JsonToken.NUMBER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public GsonProvider() {
    }

    public final k.b.a<Gson> setup(k.b.a<Gson> r7) {
        GsonBuilder r0 = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        HashMap r1 = new HashMap();
        int r4 = 0;
        r1.put(Room.class, new RoomDeserializer(r4));
        r1.put(Boolean.class, new BooleanTypeAdapter(r4));
        r1.put(Boolean.TYPE, new BooleanTypeAdapter(r4));
        Iterator r2 = r1.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Type r3 = (Type) r2.next();
        r0.registerTypeAdapter(r3, r1.get(r3));
        goto L4
    L6:
        GsonBuilder r5 = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        Iterator r6 = r1.keySet().iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        Type r8 = (Type) r6.next();
        r5.registerTypeAdapter(r8, r1.get(r8));
        goto L8
    L10:
        Gson r9 = r5.create();
        r0.registerTypeAdapter(BaseResponse.class, new BaseResponseDeserializer(r9));
        r0.registerTypeAdapter(Response.class, new ResponseDeserializer(r9));
        r0.registerTypeAdapter(BaseListResponse.class, new BaseListResponseDeserializer(r9));
        r0.registerTypeAdapter(ListResponse.class, new ListResponseDeserializer(r9));
        r0.registerTypeAdapter(e.class, new SimpleResponseInstanceCreator(r9));
        r0.registerTypeAdapter(ExtraResponse.class, new ExtraResponseInstanceCreator(r9));
        r0.registerTypeAdapter(com.bytedance.android.live.network.response.a.class, new EmptyResponseInstanceCreator(r9));
        r7.a = r0.create();
        r7.b = true;
        return r7;
    }
}
