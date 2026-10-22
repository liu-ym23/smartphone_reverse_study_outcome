package com.ss.android.lark.keyboard_biz_emoji_office;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.reaction.widget.emojipanel.EmojiPageNewFragment2;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/keyboard_biz_emoji_office/OfficeDefaultEmojiFragment;", "Lcom/ss/android/lark/reaction/widget/emojipanel/EmojiPageNewFragment2;", "<init>", "()V", "editTextDependency", "Lcom/ss/android/lark/keyboard_biz_emoji_office/IEditTextDependency;", "setEditTextDependency", "", "dependency", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onPause", "createDeleteIcon", "parent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getFirstEmojiCenterToParent", "", "getEmojiHeight", "Companion", "keyboard-biz-emoji-office_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeDefaultEmojiFragment extends EmojiPageNewFragment2 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public com.ss.android.lark.keyboard_biz_emoji_office.a f431054u;

    public static final class a {
    }

    public static final class b implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeDefaultEmojiFragment f431055a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public b(OfficeDefaultEmojiFragment r100) {
            this.f431055a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            OfficeDefaultEmojiFragment r101 = this.f431055a;
            int r102 = 0;
            if (r100 == null) goto L5;
            int r103 = r100.length();
        L6:
            if (r103 <= 0) goto L8;
            boolean r104 = true;
        L9:
            r101.V90().putBoolean("DELETE_ICON_VISIBLE", r104);
            View r105 = r101.f439345e;
            if (r105 == null) goto L16;
            if (r104 == true) goto L14;
            r102 = 8;
        L14:
            r105.setVisibility(r102);
            return;
        L16:
            return;
        L8:
            r104 = false;
            goto L9
        L5:
            r103 = 0;
            goto L6
        }
    }

    static {
    }

    @Override // com.ss.android.lark.reaction.widget.emojipanel.EmojiPageNewFragment2
    public final int W90() {
        return UIHelper.dp2px(28.0f);
    }

    @Override // com.ss.android.lark.reaction.widget.emojipanel.EmojiPageNewFragment2
    public final int X90() {
        return UIHelper.dp2px(36.0f);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        Log.i("OfficeEmojiFragment", "onPause");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        Log.i("OfficeEmojiFragment", "onResume");
        Y90();
    }

    public OfficeDefaultEmojiFragment() {
    }

    @Override // com.ss.android.lark.reaction.widget.emojipanel.EmojiPageNewFragment2
    public final View U90(ConstraintLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        ImageView r101 = new ImageView(r100.getContext());
        r101.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ConstraintLayout.LayoutParams r102 = new ConstraintLayout.LayoutParams(UIHelper.dp2px(58.0f), UIHelper.dp2px(56.0f));
        r102.bottomToBottom = 0;
        r102.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) r102).bottomMargin = UIHelper.dp2px(12.0f);
        r102.setMarginEnd(UIHelper.dp2px(12.0f));
        r101.setLayoutParams(r102);
        r101.setImageResource(R.drawable.icon_delete_left);
        r101.setBackgroundResource(R.drawable.bg_delete);
        return r101;
    }

    @Override // com.ss.android.lark.reaction.widget.emojipanel.EmojiPageNewFragment2, com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        com.ss.android.lark.keyboard_biz_emoji_office.a r102 = this.f431054u;
        if (r102 == null) goto L15;
        int r103 = 0;
        if (r102.a() <= 0) goto L7;
        boolean r104 = true;
    L8:
        V90().putBoolean("DELETE_ICON_VISIBLE", r104);
        View r105 = this.f439345e;
        if (r105 == null) goto L14;
        if (r104 == true) goto L13;
        r103 = 8;
    L13:
        r105.setVisibility(r103);
    L14:
        r102.d(new b(this));
        goto L15
    L7:
        r104 = false;
    L15:
        Y90();
    }
}
