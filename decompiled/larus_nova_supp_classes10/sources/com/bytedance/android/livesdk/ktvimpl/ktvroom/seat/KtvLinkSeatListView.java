package com.bytedance.android.livesdk.ktvimpl.ktvroom.seat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0014¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/seat/KtvLinkSeatListView;", "Landroid/widget/LinearLayout;", "", "getLayoutInd", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class KtvLinkSeatListView extends LinearLayout {

    public static final class a {
    }

    static {
    }

    public KtvLinkSeatListView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvLinkSeatListView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public int getLayoutInd() {
        return 2131566677;
    }

    public KtvLinkSeatListView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(getLayoutInd(), this, true);
    }

    public /* synthetic */ KtvLinkSeatListView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
