package m7b;

import android.view.View;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.UrlPreviewBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.x0;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f2b.a f512368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View.OnLongClickListener f512369b;

    public b(UrlPreviewBlock.b r100, f3b.d r101, x0 r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f512368a = r101;
        this.f512369b = r102;
    }
}
