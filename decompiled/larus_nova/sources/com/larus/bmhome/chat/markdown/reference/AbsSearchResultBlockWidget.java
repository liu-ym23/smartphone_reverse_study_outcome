package com.larus.bmhome.chat.markdown.reference;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ_\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H&¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0017H&¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/markdown/reference/AbsSearchResultBlockWidget;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bindData", "Landroid/util/Size;", "data", "maxWidth", "", "markdownCommonInputData", "Lcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;", "backgroundResource", "forceHideArrow", "", "blockDependConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockDependConfig;", "onClickInterceptor", "Lkotlin/Function0;", "", "(Ljava/lang/Object;ILcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/block/base/config/BlockDependConfig;Lkotlin/jvm/functions/Function0;)Landroid/util/Size;", "onRecycle", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsSearchResultBlockWidget<T> extends FrameLayout {
    public abstract Size g(SearchReferenceData r100, int r101, fh8.f r102, Integer r103, Boolean r104, Function0 r105);

    public AbsSearchResultBlockWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public AbsSearchResultBlockWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    public static /* synthetic */ Size h(AbsSearchResultBlockWidget r100, SearchReferenceData r110, int r111, fh8.f r112, Integer r113, Boolean r114, kc8.b r115, com.larus.bmhome.block.holder.deepthink.a r116, int r117) {
        if ((r117 & 16) == 0) goto L5;
        Boolean r101 = null;
    L7:
        if ((r117 & 64) == 0) goto L9;
        com.larus.bmhome.block.holder.deepthink.a r102 = null;
    L11:
        return r100.g(r110, r111, r112, r113, r101, r102);
    L9:
        r102 = r116;
        goto L11
    L5:
        r101 = r114;
        goto L7
    }
}
