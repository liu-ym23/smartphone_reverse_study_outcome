package jj8;

import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.im.bean.message.block.InteractionAskOption;
import ij8.q;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f499362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f499363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f499364c;

    public static final class a implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f499365a;

        public final BaseResourceViewHolder.a b() {
            h r100 = this.f499365a;
            f r101 = r100.f499362a;
            if (r101 != null) goto L5;
            return null;
        L5:
            g r102 = r100.f499363b;
            if (r102 != null) goto L8;
            return null;
        L8:
            return r102.c(r101);
        }

        @Override // ij8.q
        public final void onCloseClick() {
            h r100 = this.f499365a;
            f r101 = r100.f499362a;
            if (r101 != null) goto L5;
            return;
        L5:
            g r102 = r100.f499363b;
            if (r102 == null) goto L9;
            r102.a(r101);
            return;
        }

        public a(h r100) {
            this.f499365a = r100;
        }

        @Override // ij8.q
        public final void a(InteractionAskOption r100) {
            Intrinsics.checkNotNullParameter(r100, "option");
            f r101 = this.f499365a.f499362a;
            if (r101 != null) goto L5;
            return;
        L5:
            String r102 = r100.getOptionId();
            if (r102 != null) goto L9;
            r102 = "";
        L9:
            if (StringsKt.isBlank(r102) == false) goto L11;
            return;
        L11:
            g r103 = this.f499365a.f499363b;
            if (r103 == null) goto L15;
            r103.b(r101, r102);
            return;
        }
    }

    public h() {
        this.f499364c = new a(this);
    }
}
