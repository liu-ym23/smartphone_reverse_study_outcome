package com.lynx.jsbridge;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.utils.UIThreadUtils;

/* JADX INFO: loaded from: classes32.dex */
public class LynxUIMethodModule extends LynxContextModule {
    public static final String NAME = "LynxUIMethodModule";

    public class a extends f6a.e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f381343b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ReadableArray f381344c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f381345d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ReadableMap f381346e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Callback f381347f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ LynxUIMethodModule f381348g;

        @Override // f6a.e
        public final void a() {
            if (this.f381343b.isEmpty() == true) goto L5;
            String r100 = this.f381343b;
        L6:
            String r101 = r100;
            this.f381348g.mLynxContext.invokeUIMethod(r101, this.f381344c, this.f381345d, this.f381346e, LynxUIMethodModule.access$000(this.f381347f));
            return;
        L5:
            r100 = "-1";
            goto L6
        }

        public a(LynxUIMethodModule r100, LynxContext r101, String r102, ReadableArray r103, String r104, ReadableMap r105, Callback r106) {
            this.f381348g = r100;
            this.f381343b = r102;
            this.f381344c = r103;
            this.f381345d = r104;
            this.f381346e = r105;
            this.f381347f = r106;
            super(r101);
        }
    }

    public static class b implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Callback f381349a;

        public b(Callback r100) {
            this.f381349a = r100;
        }

        @Override // com.lynx.react.bridge.Callback
        public final void invoke(Object... r100) {
            if (this.f381349a != null) goto L5;
            return;
        L5:
            JavaOnlyMap r101 = new JavaOnlyMap();
            r101.putInt("code", ((Integer) r100[0]).intValue());
            if (r100.length <= 1) goto L8;
            r101.put("data", r100[1]);
        L8:
            this.f381349a.invoke(new Object[]{r101});
        }
    }

    public LynxUIMethodModule(LynxContext r100) {
        super(r100);
    }

    public static /* synthetic */ Callback access$000(Callback r100) {
        return wrapCallback(r100);
    }

    private static Callback wrapCallback(Callback r100) {
        return new b(r100);
    }

    @LynxMethod
    public void invokeUIMethod(String r110, ReadableArray r111, String r112, ReadableMap r113, Callback r114) {
        UIThreadUtils.runOnUiThread(new a(this, this.mLynxContext, r110, r111, r112, r113, r114));
    }
}
