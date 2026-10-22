package com.ss.android.lark.search.ui.result.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.exifinterface.media.ExifInterface;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import j4c.a0;
import j4c.i;
import j4c.j;
import j4c.k;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 +2\u00020\u0001:\u0001+B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0016\u0010\u001b\u001a\u0002H\u001c\"\u0006\b\u0000\u0010\u001c\u0018\u0001H\u0086\b¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u0002H\u001c\"\u0006\b\u0000\u0010\u001c\u0018\u0001H\u0086\b¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001f\u001a\u0002H\u001c\"\u0006\b\u0000\u0010\u001c\u0018\u0001H\u0086\b¢\u0006\u0002\u0010\u001dJ\u0016\u0010 \u001a\u0002H\u001c\"\u0006\b\u0000\u0010\u001c\u0018\u0001H\u0086\b¢\u0006\u0002\u0010\u001dJ\u0006\u0010!\u001a\u00020\u000bJ\u0006\u0010\"\u001a\u00020\u0001J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020*R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006,"}, d2 = {"Lcom/ss/android/lark/search/ui/result/view/AvatarItemFrameView;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "leftFrame", "Landroid/widget/FrameLayout;", "middleFrame", "rightFrame", "bottomFrame", "componentMap", "", "", "", "getComponentMap", "()Ljava/util/Map;", "searchCommonFG", "Lcom/ss/android/lark/search/ui/result/fg/FgUtils;", "getSearchCommonFG", "()Lcom/ss/android/lark/search/ui/result/fg/FgUtils;", "initComponentView", "", "getLeftFrameComponent", ExifInterface.GPS_DIRECTION_TRUE, "()Ljava/lang/Object;", "getMiddleFrameComponent", "getRightFrameComponent", "getBottomFrameComponent", "getLeftFrame", "getRightFrame", "leftViewDelegate", "Lcom/ss/android/lark/search/ui/result/view/LeftViewDelegate;", "middleViewDelegate", "Lcom/ss/android/lark/search/ui/result/view/MiddleViewDelegate;", "rightViewDelegate", "Lcom/ss/android/lark/search/ui/result/view/RightViewDelegate;", "bottomViewDelegate", "Lcom/ss/android/lark/search/ui/result/view/BottomViewDelegate;", "Companion", "search-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AvatarItemFrameView extends RelativeLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f440313g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f440314h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f440315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f440316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RelativeLayout f440317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f440318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f440319e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g4c.a f440320f;

    public static final class a {
    }

    public AvatarItemFrameView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AvatarItemFrameView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    static {
        f440313g = -1;
        f440314h = -1;
    }

    public final /* synthetic */ <T> T getBottomFrameComponent() {
        T r100 = (T) getComponentMap().get("bottom_frame");
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new Exception("target bottom frame view not found, please check");
    }

    public final /* synthetic */ <T> T getLeftFrameComponent() {
        T r100 = (T) getComponentMap().get("left_frame");
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new Exception("target left frame view not found, please check");
    }

    public final /* synthetic */ <T> T getMiddleFrameComponent() {
        T r100 = (T) getComponentMap().get("middle_frame");
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new Exception("target middle frame view not found, please check");
    }

    public final /* synthetic */ <T> T getRightFrameComponent() {
        T r100 = (T) getComponentMap().get("right_frame");
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new Exception("target right frame view not found, please check");
    }

    public final Map<String, Object> getComponentMap() {
        return this.f440319e;
    }

    public final FrameLayout getLeftFrame() {
        return this.f440315a;
    }

    public final RelativeLayout getRightFrame() {
        return this.f440317c;
    }

    public final g4c.a getSearchCommonFG() {
        return this.f440320f;
    }

    public AvatarItemFrameView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        LinkedHashMap r113 = new LinkedHashMap();
        this.f440319e = r113;
        g4c.a r100 = new g4c.a();
        this.f440320f = r100;
        setId(R.id.avatar_item);
        setBackground(AppCompatResources.getDrawable(r110, R.drawable.avatar_item_selector_bg));
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        setMinimumHeight(a0.a(72.0f, r110));
        View r101 = LayoutInflater.from(r110).inflate(R.layout.avatar_item_frame_view, this, false);
        r101.setBackground(AppCompatResources.getDrawable(r110, R.drawable.avatar_item_selector_bg));
        RelativeLayout.LayoutParams r102 = new RelativeLayout.LayoutParams(-1, -2);
        r102.addRule(10);
        r102.addRule(12);
        r102.addRule(15);
        r101.setLayoutParams(r102);
        addView(r101);
        FrameLayout r103 = (FrameLayout) findViewById(R.id.avatar_item_left_frame);
        this.f440315a = r103;
        FrameLayout r104 = (FrameLayout) findViewById(R.id.avatar_item_middle_frame);
        this.f440316b = r104;
        RelativeLayout r105 = (RelativeLayout) findViewById(R.id.avatar_item_right_frame);
        this.f440317c = r105;
        FrameLayout r106 = (FrameLayout) findViewById(R.id.avatar_item_bottom_frame);
        this.f440318d = r106;
        TypedArray r114 = r110.obtainStyledAttributes(r111, new int[]{R.attr.bottom_frame_layout, R.attr.left_frame_layout, R.attr.middle_frame_layout, R.attr.right_frame_layout});
        int r107 = r114.getResourceId(1, -1);
        int r108 = r114.getResourceId(2, -1);
        int r109 = r114.getResourceId(3, -1);
        int r115 = r114.getResourceId(0, -1);
        r114.recycle();
        if (r107 == (-1)) goto L5;
        LayoutInflater.from(r110).inflate(r107, r103);
    L6:
        if (r108 == (-1)) goto L8;
        LayoutInflater.from(r110).inflate(r108, r104);
    L9:
        if (r109 == (-1)) goto L11;
        LayoutInflater.from(r110).inflate(r109, r105);
    L12:
        if (r115 == (-1)) goto L14;
        LayoutInflater.from(r110).inflate(r115, r106);
        return;
    L14:
        r113.put("bottom_frame", new i(r110, r106));
        return;
    L11:
        r113.put("right_frame", new k(r110, r105));
        goto L12
    L8:
        j r116 = new j(r110, r100);
        r104.addView(r116);
        r113.put("middle_frame", r116);
        goto L9
    L5:
        DefaultLeftComponentView r117 = new DefaultLeftComponentView(r110, null, 0, 14);
        r103.addView(r117);
        r113.put("left_frame", r117);
        goto L6
    }

    public /* synthetic */ AvatarItemFrameView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
