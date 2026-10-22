package com.ss.android.lark.chatbase.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0010B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\tR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/chatbase/view/ChatImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onImageDrawableChangedListener", "Lcom/ss/android/lark/chatbase/view/ChatImageView$OnImageDrawableChangedListener;", "setImageDrawable", "", "drawable", "Landroid/graphics/drawable/Drawable;", "setOnImageDrawableChangedListener", "listener", "OnImageDrawableChangedListener", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f416903a;

    public interface a {
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r100) {
        super.setImageDrawable(r100);
        a r101 = this.f416903a;
        if (r101 == null) goto L18;
        ChatImageGroup r102 = ((com.ss.android.lark.chatbase.view.a) r101).f416921a;
        int r103 = ChatImageGroup.f416892k;
        r102.getClass();
        if ((r100 instanceof GifDrawable) == false) goto L7;
    L8:
        WeakReference<RecyclerView> r104 = r102.f416898f;
        if (r104 == null) goto L20;
        RecyclerView r105 = r104.get();
        if (r105 != null) goto L13;
        return;
    L13:
        if (r105.getScrollState() != 0) goto L15;
        boolean r106 = true;
    L16:
        r102.a(r106);
        return;
    L15:
        r106 = false;
        goto L16
    L20:
        return;
    L7:
        if ((r100 instanceof WebpDrawable) == true) goto L8;
        return;
    }

    public final void setOnImageDrawableChangedListener(a r100) {
        this.f416903a = r100;
    }

    public ChatImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
