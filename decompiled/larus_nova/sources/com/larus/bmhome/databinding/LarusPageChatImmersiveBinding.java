package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.bmhome.chat.immerse.ChatImmerseConstraintLayout;
import com.larus.common_ui.widget.RedDotTextView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusPageChatImmersiveBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChatImmerseConstraintLayout f311148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f311149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewPager2 f311150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RedDotTextView f311151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f311152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConstraintLayout f311153f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConstraintLayout f311154g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ConstraintLayout f311155h;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f311148a;
    }

    public LarusPageChatImmersiveBinding(ChatImmerseConstraintLayout r100, AppCompatImageView r101, ViewPager2 r102, RedDotTextView r103, ImageView r104, ConstraintLayout r105, ConstraintLayout r106, ConstraintLayout r107) {
        this.f311148a = r100;
        this.f311149b = r101;
        this.f311150c = r102;
        this.f311151d = r103;
        this.f311152e = r104;
        this.f311153f = r105;
        this.f311154g = r106;
        this.f311155h = r107;
    }
}
