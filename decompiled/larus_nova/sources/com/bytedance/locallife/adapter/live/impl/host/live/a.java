package com.bytedance.locallife.adapter.live.impl.host.live;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public class a implements it6.e {

    /* JADX INFO: renamed from: com.bytedance.locallife.adapter.live.impl.host.live.a$a, reason: collision with other inner class name */
    public static final class C3643a implements jt6.a {
        public C3643a() {
        }

        @Override // jt6.a
        public final JSONObject a(FragmentActivity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            return null;
        }

        @Override // jt6.a
        public final void b(String r100, String r101, Bundle r102) {
            Intrinsics.checkNotNullParameter(r100, "roomId");
            Intrinsics.checkNotNullParameter(r101, "label");
            Intrinsics.checkNotNullParameter(r102, "params");
        }

        @Override // jt6.a
        public final void c() {
        }

        @Override // jt6.a
        public final void d(String r100, String r101, String r102, JSONObject r103) {
            Intrinsics.checkNotNullParameter(r100, "roomId");
            Intrinsics.checkNotNullParameter(r101, "label");
            Intrinsics.checkNotNullParameter(r102, "refer");
        }

        @Override // jt6.a
        public final void e(String r100, String r101, JSONObject r102) {
            Intrinsics.checkNotNullParameter(r100, "roomId");
            Intrinsics.checkNotNullParameter(r101, "label");
            Intrinsics.checkNotNullParameter("card_new", "refer");
        }

        @Override // jt6.a
        public final void f(String r100) {
            Intrinsics.checkNotNullParameter(r100, "finalLogExtra");
        }

        @Override // jt6.a
        public final void log(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "roomId");
            Intrinsics.checkNotNullParameter(r101, "action");
        }
    }

    public a() {
    }

    @Override // it6.e
    public jt6.a a() {
        return new C3643a();
    }
}
