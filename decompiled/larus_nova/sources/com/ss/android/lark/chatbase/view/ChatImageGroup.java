package com.ss.android.lark.chatbase.view;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.chatwindow.chat.view.IMCircleLoadingView;
import com.ss.android.lark.widget.DonutProgress;
import com.ss.android.lark.widget.mark.MarkView;
import java.lang.ref.WeakReference;
import pl.droidsonroids.gif.GifImageView;

/* JADX INFO: loaded from: classes35.dex */
public class ChatImageGroup extends FrameLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f416892k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ChatImageView f416893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GifImageView f416894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DonutProgress f416895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f416896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f416897e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakReference<RecyclerView> f416898f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f416899g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MarkView f416900h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MarkView f416901i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public IMCircleLoadingView f416902j;

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f416897e == false) goto L5;
        return;
    L5:
        if (this.f416893a.getVisibility() != 0) goto L25;
        ViewParent r100 = getParent();
    L9:
        if ((r100 instanceof ViewGroup) == false) goto L26;
        if ((r100 instanceof RecyclerView) == true) goto L13;
        r100 = ((ViewGroup) r100).getParent();
        goto L9
    L13:
        RecyclerView r101 = (RecyclerView) r100;
        this.f416898f = new WeakReference(r101);
        if (this.f416899g != null) goto L16;
        this.f416899g = new b(this);
    L16:
        r101.addOnScrollListener(this.f416899g);
        if (r101.getScrollState() != 0) goto L19;
        boolean r102 = true;
    L20:
        a(r102);
        this.f416897e = true;
        return;
    L19:
        r102 = false;
        goto L20
    L26:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f416897e == false) goto L14;
        WeakReference<RecyclerView> r100 = this.f416898f;
        if (r100 != null) goto L7;
        return;
    L7:
        if (this.f416899g == null) goto L16;
        RecyclerView r101 = r100.get();
        if (r101 == null) goto L17;
        r101.removeOnScrollListener(this.f416899g);
        this.f416897e = false;
        return;
    L17:
        return;
    L16:
        return;
    }

    public ChatImageGroup(Context r100) {
        super(r100);
        b(r100);
    }

    public final void a(boolean r100) {
        Object r101 = this.f416893a.getDrawable();
        if (this.f416893a.getVisibility() == 0) goto L6;
        return;
    L6:
        if ((r101 instanceof GifDrawable) == false) goto L8;
    L9:
        if (r100 == false) goto L11;
        ((Animatable) r101).start();
        return;
    L11:
        ((Animatable) r101).stop();
        return;
    L8:
        if ((r101 instanceof WebpDrawable) == true) goto L9;
    }

    public final void b(Context r100) {
        this.f416896d = r100;
        setBackgroundColor(v2c.a.b(r100, R.color.bg_body_overlay));
        LayoutInflater.from(getContext()).inflate(R.layout.chat_image_group, this, true);
        ChatImageView r101 = (ChatImageView) findViewById(R.id.chat_image);
        this.f416893a = r101;
        r101.setOnImageDrawableChangedListener(new a(this));
        this.f416894b = (GifImageView) findViewById(R.id.chat_sticker);
        DonutProgress r102 = (DonutProgress) findViewById(R.id.upload_progress);
        this.f416895c = r102;
        r102.setMax(100);
        this.f416900h = (MarkView) findViewById(R.id.resource_is_cleaned_tip);
        this.f416901i = (MarkView) findViewById(R.id.tv_image_tag);
        this.f416902j = (IMCircleLoadingView) findViewById(R.id.loading_view);
        this.f416893a.setVisibility(0);
        this.f416894b.setVisibility(8);
    }

    public synchronized void setProgress(int r100) {
        monitor-enter(this);
        if (r100 >= 0) goto L19;
        r100 = 0;
    L19:
        if (r100 < 100) goto L9;
        this.f416895c.setVisibility(8);     // Catch: Throwable -> L16
        this.f416893a.clearColorFilter();     // Catch: Throwable -> L16
    L13:
        this.f416895c.setProgress(r100);     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L9:
        if (this.f416895c.getVisibility() == 0) goto L11;
        this.f416895c.setVisibility(0);     // Catch: Throwable -> L16
    L11:
        this.f416893a.setColorFilter(UDColorUtils.getColor(this.f416896d, R.color.ud_N900_30));     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public ChatImageGroup(Context r100, AttributeSet r101) {
        super(r100, r101);
        b(r100);
    }

    public ChatImageGroup(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        b(r100);
    }
}
