package com.bytedance.caijing.sdk.infra.base.api.container.interfaceWrapper;

import android.text.TextUtils;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class JSBResult {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f202211e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f202212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f202213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f202214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f202215d;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/container/interfaceWrapper/JSBResult$CODE;", "", "", "value", "I", "getValue", "()I", "SUCCESS", "ERROR", "NOT_FOUND", "NO_PRIVILEGE", "PARAMS_ERROR", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
    public static final enum CODE extends Enum<CODE> {
        public static final CODE ERROR = null;
        public static final CODE NOT_FOUND = null;
        public static final CODE NO_PRIVILEGE = null;
        public static final CODE PARAMS_ERROR = null;
        public static final CODE SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CODE[] f202216a = null;
        private final int value;

        public static CODE valueOf(String r100) {
            return (CODE) r27.a.a(CODE.class, r100);
        }

        public static CODE[] values() {
            return (CODE[]) f202216a.clone();
        }

        static {
            CODE r100 = new CODE("SUCCESS", 0, 1);
            SUCCESS = r100;
            CODE r101 = new CODE("ERROR", 1, 0);
            ERROR = r101;
            CODE r102 = new CODE("NOT_FOUND", 2, -2);
            NOT_FOUND = r102;
            CODE r103 = new CODE("NO_PRIVILEGE", 3, -1);
            NO_PRIVILEGE = r103;
            CODE r104 = new CODE("PARAMS_ERROR", 4, -3);
            PARAMS_ERROR = r104;
            f202216a = new CODE[]{r100, r101, r102, r103, r104};
        }

        public final int getValue() {
            return this.value;
        }

        public CODE(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
        public a() {
        }

        public static JSBResult a(String r100, JSONObject r101) {
            JSBResult r102 = new JSBResult();
            r102.f202212a = CODE.ERROR.getValue();
            if (TextUtils.isEmpty(r100) == true) goto L5;
            r102.f202213b = r100;
        L5:
            if (r101 == null) goto L7;
            r102.f202214c = r101;
        L7:
            return r102;
        }

        public static JSBResult b(JSONObject r100, String r101) {
            JSBResult r102 = new JSBResult();
            r102.f202212a = CODE.SUCCESS.getValue();
            if (TextUtils.isEmpty(r101) == true) goto L5;
            r102.f202213b = r101;
        L5:
            r102.f202214c = r100;
            r102.f202215d = false;
            return r102;
        }
    }

    static {
        new a();
    }

    public JSBResult() {
        this.f202212a = CODE.ERROR.getValue();
    }
}
