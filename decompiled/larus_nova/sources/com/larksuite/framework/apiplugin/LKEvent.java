package com.larksuite.framework.apiplugin;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.larksuite.framework.apiplugin.annotation.LKIncludeWithFailData;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larksuite.framework.apiplugin.entity.LKBasePluginResult;
import com.larksuite.framework.apiplugin.entity.LKPluginHandleResult;
import com.ss.android.lark.log.Log;
import j18.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public class LKEvent implements Parcelable {
    public static final Parcelable.Creator<LKEvent> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f285488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f285489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j18.b f285490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f285491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Context f285492e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final JSONObject f285493f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f285494g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f285495h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, Object> f285496i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public i18.c f285497j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public j18.a f285498k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final EventSourceEnv f285499l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final p18.b f285500m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f285501n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Bundle f285502o;

    public static final enum EventSourceEnv extends Enum<EventSourceEnv> {
        public static final EventSourceEnv APP_ENV = null;
        public static final EventSourceEnv BIZ_ENV = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EventSourceEnv[] f285503a = null;

        static {
            EventSourceEnv r100 = new EventSourceEnv("APP_ENV", 0);
            APP_ENV = r100;
            EventSourceEnv r101 = new EventSourceEnv("BIZ_ENV", 1);
            BIZ_ENV = r101;
            f285503a = new EventSourceEnv[]{r100, r101};
        }

        public static EventSourceEnv[] values() {
            return (EventSourceEnv[]) f285503a.clone();
        }

        public static EventSourceEnv valueOf(String r100) {
            return (EventSourceEnv) r27.a.a(EventSourceEnv.class, r100);
        }

        public EventSourceEnv(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements Parcelable.Creator<LKEvent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LKEvent createFromParcel(Parcel r100) {
            return new LKEvent(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final LKEvent[] newArray(int r100) {
            return new LKEvent[r100];
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f285504a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public JSONObject f285505b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Context f285506c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f285507d;

        public b() {
            this.f285507d = false;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final hyb.a c() {
        p18.b r100 = this.f285500m;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.f527327b;
    }

    public Context getContext() {
        return this.f285492e;
    }

    public LKEvent(Parcel r100) {
        boolean r101 = false;
        this.f285501n = false;
        this.f285488a = r100.readString();
        this.f285491d = r100.readInt();
        if (r100.readByte() == 0) goto L5;
        r101 = true;
    L5:
        this.f285501n = r101;
        String r102 = r100.readString();
        if (TextUtils.isEmpty(r102) == true) goto L10;
        Object r103 = JSON.parse(r102);
        if ((r103 instanceof Map) == false) goto L10;
        this.f285496i = (Map) r103;
    L10:
        Serializable r104 = r100.readSerializable();
        if ((r104 instanceof EventSourceEnv) == false) goto L13;
        this.f285499l = (EventSourceEnv) r104;
    L13:
        this.f285500m = new p18.b();
        String r105 = r100.readString();
    L18:
        e = move-exception;
        Log.e("LKEvent", "JSONException", e);
    L21:
        if (this.f285489b != null) goto L23;
        this.f285489b = new JSONObject();
        Log.i("LKEvent", "event params is empty!");
    L23:
        this.f285502o = r100.readBundle(getClass().getClassLoader());
        return;
    L15:
        if (TextUtils.isEmpty(r105) == true) goto L21;
        this.f285489b = new JSONObject(r105);     // Catch: JSONException -> L18
        goto L21
    }

    public final void a(JSONObject r100) {
        JSONObject r101 = this.f285493f;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.length() <= 0) goto L29;
        if (r100 != null) goto L8;
        r100 = new JSONObject();
    L8:
        Iterator<String> r102 = this.f285493f.keys();
    L10:
        if (r102.hasNext() == false) goto L30;
        String r103 = r102.next();
        r100.put(r103, this.f285493f.get(r103));     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        hyb.a r104 = c();
        if (r104 != null) goto L17;
        Log.e("LKEvent", "JSONException", e);
        goto L10
    L17:
        r104.e("LKEvent", new Object[]{"JSONException", e});
        goto L10
    L30:
        return;
    }

    public final void b(Object r110) {
        if (r110 == null) goto L89;
        JSONObject r100 = new JSONObject();
        k18.a r101 = k18.a.f501383c;     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        r100.put("errMsg", "internal error");     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        if ((r110 instanceof LKBaseResponseModel) == false) goto L59;
        LKBaseResponseModel r102 = (LKBaseResponseModel) r110;     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        if (r102.optimizeJsonParse() == false) goto L11;
        JSONObject r103 = r18.a.a((com.alibaba.fastjson.JSONObject) JSON.toJSON(r102));     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
    L14:
        r18.b.a(r103, (LKBaseResponseModel) r110);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        r103.put("errMsg", r18.b.c(r102));     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        if (r102.mIsArrayBuffer == true) goto L17;
    L19:
        boolean r104 = false;
    L21:
        if (r104 == false) goto L39;
        LKPluginHandleResult.a r105 = new LKPluginHandleResult.a();     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        if (r102.isFail() == true) goto L25;
    L31:
        r105.f285525a = r103;     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        r105.f285533e = r102.isCease();     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        List<LKBasePluginResult.b.a> r111 = r102.getArrayBuffers();     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        if (r105.f285528d != null) goto L34;
        r105.f285528d = new ArrayList();     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
    L34:
        ((ArrayList) r105.f285528d).addAll(r111);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        if (r102.isFail() == false) goto L98;
        r105.f285527c = r102.getApiErrCode().f516673a;     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
    L98:
        return;
    L25:
        if (((LKBaseResponseModel) r110).getClass().getAnnotation(LKIncludeWithFailData.class) != null) goto L27;
        boolean r112 = true;
    L28:
        if (r112 == false) goto L30;
        r103 = q18.c.d(r102);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        goto L31
    L30:
        r103.remove("apiErrNo");     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        goto L31
    L27:
        r112 = false;
        goto L28
    L39:
        if (r102.isFail() == false) goto L55;
        hyb.a r106 = c();     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        if (r106 == null) goto L44;
        ((p18.b.a) r106).i("LKEvent", new Object[]{"errorCode:" + r102.getApiErrCode() + " eventName:" + this.f285488a});     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
    L46:
        if (((LKBaseResponseModel) r110).getClass().getAnnotation(LKIncludeWithFailData.class) != null) goto L48;
        boolean r113 = true;
    L49:
        if (r113 == false) goto L51;
        r103 = q18.c.d(r102);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
    L52:
        int r114 = r102.getApiErrCode().f516673a;     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        if (this.f285494g == null) goto L99;
        a(r103);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        this.f285494g.onFail(r114, r103);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        return;
    L99:
        return;
    L51:
        r103.remove("apiErrNo");     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        goto L52
    L48:
        r113 = false;
        goto L49
    L44:
        Log.i("LKEvent", "errorCode:" + r102.getApiErrCode() + " eventName:" + this.f285488a);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        goto L46
    L55:
        r103.remove(LKBaseResponseModel.INNER_CODE_KEY);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        r103.remove(LKBaseResponseModel.ERROR_NO_KEY);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        r103.remove(LKBaseResponseModel.ERROR_STRING_KEY);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        if (this.f285494g == null) goto L101;
        a(r103);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        this.f285494g.onSuccess(r103);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        return;
    L101:
        return;
    L17:
        if (r102.getArrayBuffers() == null) goto L19;
        r104 = true;
        goto L21
    L11:
        if (r102.getSerializeFilter() == null) goto L13;
        r103 = new JSONObject(JSON.toJSONString(r102, r102.getSerializeFilter(), new SerializerFeature[0]));     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        goto L14
    L13:
        r103 = new JSONObject(JSON.toJSONString(r102));     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        goto L14
    L59:
        if ((r110 instanceof JSONObject) == false) goto L62;
        JSONObject r115 = (JSONObject) r110;     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
    L70:
        if (this.f285494g == null) goto L103;
        a(r115);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        this.f285494g.onSuccess(r115);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        return;
    L103:
        return;
    L62:
        if ((r110 instanceof Map) == false) goto L66;
        JSONObject r107 = new JSONObject((Map) r110);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
    L64:
        r115 = r107;
        goto L70
    L66:
        if ((r110 instanceof String) == false) goto L68;
        r110 = JSON.parseObject((String) r110);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
    L68:
        r107 = new JSONObject(JSON.toJSONString(r110));     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
    L73:
        e = move-exception;
        hyb.a r108 = c();
        if (r108 == null) goto L77;
        ((p18.b.a) r108).e("LKEvent", new Object[]{"fast JSONException", e});
    L78:
        k18.a r116 = k18.a.f501383c;
        if (this.f285494g == null) goto L104;
        a(r100);
        this.f285494g.onFail(102, r100);
        return;
    L104:
        return;
    L77:
        Log.e("LKEvent", "fast JSONException", e);
    L81:
        e = move-exception;
        hyb.a r109 = c();
        if (r109 == null) goto L85;
        ((p18.b.a) r109).e("LKEvent", new Object[]{"JSONException", e});
    L86:
        k18.a r117 = k18.a.f501383c;
        if (this.f285494g == null) goto L106;
        a(r100);
        this.f285494g.onFail(102, r100);
        return;
    L106:
        return;
    L85:
        Log.e("LKEvent", "JSONException", e);
        goto L86
    L89:
        hyb.a r118 = c();
        if (r118 == null) goto L92;
        ((p18.b.a) r118).i("LKEvent", new Object[]{"result is null"});
    L93:
        JSONObject r119 = new JSONObject();
        if (this.f285494g == null) goto L108;
        a(r119);
        this.f285494g.onSuccess(r119);
        return;
    L108:
        return;
    L92:
        Log.i("LKEvent", "result is null");
        goto L93
    }

    public final void e(j18.b r100) {
        this.f285490c = r100;
        if (r100 == null) goto L7;
        this.f285497j = r100.getBridgeContext();
        if (this.f285492e != null) goto L7;
        this.f285492e = this.f285490c.getContext();
    L7:
        hyb.a r101 = c();
        if (r101 == null) goto L10;
        r101.d("LKEvent", new Object[]{"setSourceNode"});
        return;
    L10:
        Log.d("LKEvent", "setSourceNode");
    }

    public LKEvent(b r100) {
        this.f285501n = false;
        this.f285501n = r100.f285507d;
        this.f285500m = new p18.b();
        this.f285493f = new JSONObject();
        this.f285488a = r100.f285504a;
        this.f285489b = r100.f285505b;
        this.f285492e = r100.f285506c;
        this.f285491d = -1;
        this.f285491d = new Random().nextInt();
        this.f285496i = new HashMap();
        new HashMap();
        e(null);
        this.f285502o = null;
    }

    public static LKPluginHandleResult d(int r100, JSONObject r101) {
        LKPluginHandleResult.a r102 = new LKPluginHandleResult.a();
        r102.f285525a = r101;
        r102.f285527c = r100;
        r102.f285533e = true;
        return new LKPluginHandleResult(r102);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f285488a);
        r100.writeInt(this.f285491d);
        r100.writeByte(this.f285501n ? 1 : 0);
        Map<String, Object> r102 = this.f285496i;
        String r103 = "";
        if (r102 == null) goto L5;
        String r104 = JSON.toJSONString(r102);
    L6:
        r100.writeString(r104);
        r100.writeSerializable(this.f285499l);
        JSONObject r105 = this.f285489b;
        if (r105 == null) goto L9;
        r103 = r105.toString();
    L9:
        r100.writeString(r103);
        r100.writeBundle(this.f285502o);
        return;
    L5:
        r104 = "";
        goto L6
    }
}
