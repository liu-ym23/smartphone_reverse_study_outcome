package com.bytedance.awemeopen.apps.framework.comment.write.emojichoose;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.comment.util.CommentKeyboardUtils;
import com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.choose.EmojiChooseParams;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f194449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f194450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EmojiGridPage f194451c;

    public final void a() {
        int r100 = CommentKeyboardUtils.b(false, false);
        if (r100 <= 0) goto L15;
        View r101 = this.f194450b;
        if (r101 == null) goto L7;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
    L8:
        if (r102 == null) goto L11;
        r102.height = r100;
    L11:
        View r103 = this.f194450b;
        if (r103 == null) goto L16;
        r103.requestLayout();
        return;
    L16:
        return;
    L7:
        r102 = null;
        goto L8
    }

    public final void b(boolean r100) {
        EmojiGridPage r101 = this.f194451c;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public a(vy3.a r100, ViewGroup r101, com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.c r102, EmojiChooseParams r103) {
        Intrinsics.checkNotNullParameter(r100, "inputApi");
        Intrinsics.checkNotNullParameter(r101, "parentContainer");
        Intrinsics.checkNotNullParameter(r102, "iInputViewBridge");
        Intrinsics.checkNotNullParameter(r103, "mEmojiChooseParams");
        this.f194449a = r101;
        boolean r104 = false;
        View r105 = LayoutInflater.from(r101.getContext()).inflate(R.layout.aos_emoji_page_layout_small_emoji, r101, false);
        this.f194450b = r105;
        d r106 = new d(r101.getContext());
        r106.f194455b = r105;
        r106.f194456c = r102;
        r106.f194457d = r103;
        final EmojiGridPage r107 = new EmojiGridPage(r100, r106);
        this.f194451c = r107;
        final GridLayoutManager r108 = new GridLayoutManager(r107.f194429c, 7, 1, false);
        r108.setSpanSizeLookup(new EmojiGridPage$initView$1(r107, r108));
        r107.f194433g.setLayoutManager(r108);
        SmallEmojiPanelAdapter r109 = (SmallEmojiPanelAdapter) r107.f194434h.getValue();
        if (r109 == null) goto L42;
        r109.f194443d = r107.f194431e;
        r107.f194437k = r107.f194432f.findViewById(R.id.send_delete_btn_container);
        r107.f194436j = (DmtTextView) r107.f194432f.findViewById(R.id.send_btn);
        r107.f194435i = (DmtTextView) r107.f194432f.findViewById(R.id.delete_btn);
        if (r107.f194430d.enableSmallEmojiSendBtn == false) goto L11;
        DmtTextView r110 = r107.f194436j;
        if (r110 == null) goto L11;
        r110.setVisibility(0);
        DmtTextView r111 = r107.f194436j;
        if (r111 == null) goto L11;
        r111.setOnClickListener(new c(r107));
    L11:
        DmtTextView r112 = r107.f194435i;
        if (r112 == null) goto L16;
        r112.setVisibility(0);
        DmtTextView r113 = r107.f194435i;
        if (r113 == null) goto L16;
        r113.setOnClickListener(new b(r107));
    L16:
        View r114 = r107.f194437k;
        if (r114 == null) goto L21;
        r114.setVisibility(0);
    L21:
        if (n0.c(r107.f194432f.getContext()) == false) goto L28;
        View r115 = r107.f194437k;
        if (r115 == null) goto L25;
        r115.setBackgroundResource(R.drawable.aos_emoji_delete_mask_v1_dark);
    L25:
        DmtTextView r116 = r107.f194435i;
        if (r116 == null) goto L34;
        r116.setBackgroundResource(R.drawable.aos_emoji_delete_icon_dark);
    L34:
        e r117 = r107.f194431e;
        if (r117 == null) goto L41;
        String r118 = r117.c();
        if (r118 == null) goto L41;
        if (r118.length() <= 0) goto L41;
        r104 = true;
    L41:
        r107.a(r104);
        goto L42
    L28:
        View r119 = r107.f194437k;
        if (r119 == null) goto L31;
        r119.setBackgroundResource(R.drawable.aos_emoji_delete_mask_v1);
    L31:
        DmtTextView r120 = r107.f194435i;
        if (r120 == null) goto L34;
        r120.setBackgroundResource(R.drawable.aos_emoji_delete_icon);
    L42:
        r107.f194433g.setAdapter((SmallEmojiPanelAdapter) r107.f194434h.getValue());
        if (n0.c(r105.getContext()) == false) goto L45;
        r105.setBackgroundColor(r101.getContext().getResources().getColor(R.color.aos_common_emoji_bg_color_dark));
    L46:
        a();
        return;
    L45:
        r105.setBackgroundColor(r101.getContext().getResources().getColor(R.color.aos_common_emoji_bg_color));
        goto L46
    }
}
