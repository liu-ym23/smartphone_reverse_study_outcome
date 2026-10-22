package pi8;

import android.view.View;
import com.larus.bmhome.chat.search.VideoInfo;
import com.larus.bmhome.chat.search.factory.SearchHolderAttachBizType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class s extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VideoInfo f529394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f529395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f529396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f529397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SearchHolderAttachBizType f529398e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f529394a, r101.f529394a) == true) goto L12;
        return false;
    L12:
        if (this.f529395b == r101.f529395b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f529396c, r101.f529396c) == true) goto L18;
        return false;
    L18:
        if (this.f529397d == r101.f529397d) goto L21;
        return false;
    L21:
        if (this.f529398e == r101.f529398e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f529394a.hashCode() * 31) + this.f529395b) * 31) + this.f529396c.hashCode()) * 31;
        if (this.f529397d == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f529398e.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "VideoHolderCallbackData(itemData=" + this.f529394a + ", position=" + this.f529395b + ", itemView=" + this.f529396c + ", isSimpleSearch=" + this.f529397d + ", attachBizType=" + this.f529398e + ')';
    }

    public s(VideoInfo r100, int r101, View r102, boolean r103, SearchHolderAttachBizType r104) {
        Intrinsics.checkNotNullParameter(r100, "itemData");
        Intrinsics.checkNotNullParameter(r102, "itemView");
        Intrinsics.checkNotNullParameter(r104, "attachBizType");
        this.f529394a = r100;
        this.f529395b = r101;
        this.f529396c = r102;
        this.f529397d = r103;
        this.f529398e = r104;
    }

    public /* synthetic */ s(VideoInfo r100, int r101, View r102, boolean r110, int r111) {
        if ((r111 & 8) == 0) goto L5;
        boolean r103 = false;
    L7:
        if ((r111 & 16) == 0) goto L9;
        SearchHolderAttachBizType r112 = SearchHolderAttachBizType.Other;
    L10:
        this(r100, r101, r102, r103, r112);
        return;
    L9:
        r112 = null;
        goto L10
    L5:
        r103 = r110;
        goto L7
    }
}
