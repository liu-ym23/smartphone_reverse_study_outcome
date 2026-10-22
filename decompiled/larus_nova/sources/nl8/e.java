package nl8;

import android.view.View;
import com.larus.bmhome.chat.standarduikit.browsercontrol.view.ButtonStatus;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f519557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public nl8.a f519558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ButtonStatus f519559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f519560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f519561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f519562f;

    public static final class a implements fj8.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f519563a;

        @Override // fj8.b
        public final void onRejectClick() {
        }

        @Override // fj8.b
        public final void a() {
            nl8.a r100 = this.f519563a.f519558b;
            boolean r101 = false;
            if (r100 != null) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == true) goto L10;
            return;
        L10:
            if (r100 != null) goto L12;
        L14:
            boolean r103 = false;
        L15:
            if (r103 == false) goto L17;
            return;
        L17:
            if (r100 == null) goto L23;
            Function0<Boolean> r104 = r100.f519552g;
            if (r104 == null) goto L23;
            if (r104.invoke().booleanValue() != true) goto L23;
            r101 = true;
        L23:
            if (r101 == false) goto L25;
            return;
        L25:
            e r105 = this.f519563a;
            r105.f519557a = !r105.f519557a;
            b r106 = r105.f519560d;
            if (r106 == null) goto L29;
            r106.a();
            return;
        L29:
            return;
        L12:
            if (r100.f519553h != true) goto L14;
            r103 = true;
            goto L15
        L5:
            if (r100.f519549d != true) goto L7;
            r102 = true;
            goto L8
        }

        public a(e r100) {
            this.f519563a = r100;
        }

        @Override // fj8.b
        public final void b(String r100, View r101) {
            Intrinsics.checkNotNullParameter(r100, "url");
            Intrinsics.checkNotNullParameter(r101, "view");
            b r102 = this.f519563a.f519560d;
            if (r102 == null) goto L6;
            r102.b(r100, r101);
            return;
        }
    }

    public e() {
        this.f519559c = ButtonStatus.HIDE;
        this.f519562f = LazyKt.lazy(new d(this));
    }
}
