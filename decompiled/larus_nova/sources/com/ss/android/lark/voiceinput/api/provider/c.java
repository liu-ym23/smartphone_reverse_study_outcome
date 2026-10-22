package com.ss.android.lark.voiceinput.api.provider;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public interface c {

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final tac.a f445040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Fragment f445041b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final dbc.c f445042c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final xac.a f445043d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f445040a, r101.f445040a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f445041b, r101.f445041b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(null, null) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f445042c, r101.f445042c) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(null, null) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f445043d, r101.f445043d) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f445040a.hashCode() * 31) + this.f445041b.hashCode()) * 31) + 0) * 31;
            dbc.c r101 = this.f445042c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((((r100 + r102) * 31) + 0) * 31) + this.f445043d.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Advanced(config=" + this.f445040a + ", fragment=" + this.f445041b + ", voiceEdit=null, voiceView=" + this.f445042c + ", consumer=null, voiceContext=" + this.f445043d + ')';
        }

        @Override // com.ss.android.lark.voiceinput.api.provider.c
        public final xac.a a() {
            return this.f445043d;
        }

        @Override // com.ss.android.lark.voiceinput.api.provider.c
        public final dbc.c b() {
            return this.f445042c;
        }

        @Override // com.ss.android.lark.voiceinput.api.provider.c
        public final tac.a getConfig() {
            return this.f445040a;
        }

        @Override // com.ss.android.lark.voiceinput.api.provider.c
        public final Fragment getFragment() {
            return this.f445041b;
        }

        public a(tac.a r100, Fragment r101, dbc.c r102, xac.a r103) {
            Intrinsics.checkNotNullParameter(r100, "config");
            Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
            Intrinsics.checkNotNullParameter(r103, "voiceContext");
            this.f445040a = r100;
            this.f445041b = r101;
            this.f445042c = r102;
            this.f445043d = r103;
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final tac.a f445044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Fragment f445045b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final xac.a f445046c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final dbc.c f445047d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f445044a, r101.f445044a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f445045b, r101.f445045b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(null, null) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f445046c, r101.f445046c) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f445047d, r101.f445047d) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f445044a.hashCode() * 31) + this.f445045b.hashCode()) * 31;
            int r101 = 0;
            int r102 = (((r100 + 0) * 31) + this.f445046c.hashCode()) * 31;
            dbc.c r103 = this.f445047d;
            if (r103 == null) goto L7;
            r101 = r103.hashCode();
        L7:
            return r102 + r101;
        }

        public final String toString() {
            return "Immersive(config=" + this.f445044a + ", fragment=" + this.f445045b + ", consumer=null, voiceContext=" + this.f445046c + ", voiceView=" + this.f445047d + ')';
        }

        @Override // com.ss.android.lark.voiceinput.api.provider.c
        public final xac.a a() {
            return this.f445046c;
        }

        @Override // com.ss.android.lark.voiceinput.api.provider.c
        public final dbc.c b() {
            return this.f445047d;
        }

        @Override // com.ss.android.lark.voiceinput.api.provider.c
        public final tac.a getConfig() {
            return this.f445044a;
        }

        @Override // com.ss.android.lark.voiceinput.api.provider.c
        public final Fragment getFragment() {
            return this.f445045b;
        }

        public b(tac.a r100, Fragment r101, xac.a r102) {
            Intrinsics.checkNotNullParameter(r100, "config");
            Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
            Intrinsics.checkNotNullParameter(r102, "voiceContext");
            this.f445044a = r100;
            this.f445045b = r101;
            this.f445046c = r102;
            this.f445047d = null;
        }
    }

    xac.a a();

    dbc.c b();

    tac.a getConfig();

    Fragment getFragment();
}
