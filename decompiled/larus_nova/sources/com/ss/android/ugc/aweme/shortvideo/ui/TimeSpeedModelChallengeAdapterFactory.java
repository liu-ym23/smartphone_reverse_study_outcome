package com.ss.android.ugc.aweme.shortvideo.ui;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.ss.android.ugc.aweme.shortvideo.AVChallenge;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/ui/TimeSpeedModelChallengeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "<init>", "()V", "TimeSpeedModelChallengeAdapter", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class TimeSpeedModelChallengeAdapterFactory implements TypeAdapterFactory {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/ui/TimeSpeedModelChallengeAdapterFactory$TimeSpeedModelChallengeAdapter;", "Lcom/google/gson/TypeAdapter;", "", "Lcom/ss/android/ugc/aweme/shortvideo/AVChallenge;", "lib-api_release"}, k = 1, mv = {1, 4, 1})
    public static final class TimeSpeedModelChallengeAdapter extends TypeAdapter<List<? extends AVChallenge>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TypeAdapter<AVChallenge> f454272a;

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
        public final /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f454273a = null;

            static {
                int[] r100 = new int[JsonToken.values().length];
                f454273a = r100;
                r100[JsonToken.NULL.ordinal()] = 1;
                r100[JsonToken.BEGIN_ARRAY.ordinal()] = 2;
                r100[JsonToken.BEGIN_OBJECT.ordinal()] = 3;
            }
        }

        public TimeSpeedModelChallengeAdapter(Gson r100) {
            Intrinsics.checkNotNullParameter(r100, "gson");
            this.f454272a = r100.getAdapter(AVChallenge.class);
        }

        @Override // com.google.gson.TypeAdapter
        public final List<? extends AVChallenge> read(JsonReader r100) {
            if (r100 == null) goto L20;
            JsonToken r101 = r100.peek();
            if (r101 == null) goto L19;
            int r102 = WhenMappings.f454273a[r101.ordinal()];
            if (r102 != 1) goto L9;
            return null;
        L9:
            if (r102 != 2) goto L11;
            r100.beginArray();
            ArrayList r103 = new ArrayList();
        L15:
            if (r100.hasNext() == false) goto L17;
            r103.add(this.f454272a.read(r100));
            goto L15
        L17:
            r100.endArray();
            return r103;
        L11:
            if (r102 != 3) goto L19;
            return CollectionsKt.listOf(this.f454272a.read(r100));
        L19:
            throw new JsonParseException("Expected JSON ARRAY or JSON OBJECT ");
        L20:
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter r100, List<? extends AVChallenge> r101) {
            List<? extends AVChallenge> r102 = r101;
            if (r100 == null) goto L15;
            if (r102 == null) goto L12;
            r100.beginArray();
            Iterator<T> r103 = r102.iterator();
        L7:
            if (r103.hasNext() == false) goto L10;
            AVChallenge r104 = (AVChallenge) r103.next();
            this.f454272a.write(r100, r104);
            goto L7
        L10:
            if (r100.endArray() == null) goto L12;
            return;
        L12:
            r100.nullValue();
            return;
        }
    }

    public TimeSpeedModelChallengeAdapterFactory() {
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final <T> TypeAdapter<T> create(Gson r100, TypeToken<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "gson");
        Intrinsics.checkNotNullParameter(r101, "type");
        if ((!Intrinsics.areEqual(r101, new TimeSpeedModelChallengeAdapterFactory$create$listType$1())) == false) goto L9;
        if ((!Intrinsics.areEqual(r101.getRawType(), AVChallenge.class)) == false) goto L9;
        return null;
    L9:
        return new TimeSpeedModelChallengeAdapter(r100);
    }
}
