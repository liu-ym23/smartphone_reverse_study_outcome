package com.ss.android.lark.ui.component_container;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011B1\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/ui/component_container/ResponsiveContainerOptions;", "Ljava/io/Serializable;", "insetsCompat", "", "swipeToDismissEnabled", "backgroundStrategy", "Lcom/ss/android/lark/ui/component_container/BackgroundStrategy;", "enableDynamicBackground", "<init>", "(ZZLcom/ss/android/lark/ui/component_container/BackgroundStrategy;Z)V", "getInsetsCompat", "()Z", "getSwipeToDismissEnabled", "getBackgroundStrategy", "()Lcom/ss/android/lark/ui/component_container/BackgroundStrategy;", "getEnableDynamicBackground", "Companion", "Builder", "widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResponsiveContainerOptions implements Serializable {
    public static final b Companion = null;
    public static final String KEY_CONTAINER_ENABLE_DYNAMIC_BG = "key_enable_dynamic_bg";
    private final BackgroundStrategy backgroundStrategy;
    private final boolean enableDynamicBackground;
    private final boolean insetsCompat;
    private final boolean swipeToDismissEnabled;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f444599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f444600b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f444601c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final BackgroundStrategy f444602d;

        public final ResponsiveContainerOptions a() {
            return new ResponsiveContainerOptions(this.f444599a, this.f444600b, this.f444602d, this.f444601c);
        }

        public final String toString() {
            return "ResponsiveContainerOptions(insetsCompat=" + this.f444599a + ", swipeToDismissEnabled=" + this.f444600b + ')';
        }

        public a() {
            this.f444600b = true;
            this.f444602d = BackgroundStrategy.DEFAULT;
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
    }

    public ResponsiveContainerOptions() {
        this(false, false, null, false, 15, null);
    }

    public final BackgroundStrategy getBackgroundStrategy() {
        return this.backgroundStrategy;
    }

    public final boolean getEnableDynamicBackground() {
        return this.enableDynamicBackground;
    }

    public final boolean getInsetsCompat() {
        return this.insetsCompat;
    }

    public final boolean getSwipeToDismissEnabled() {
        return this.swipeToDismissEnabled;
    }

    public ResponsiveContainerOptions(boolean r100, boolean r101, BackgroundStrategy r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r102, "backgroundStrategy");
        this.insetsCompat = r100;
        this.swipeToDismissEnabled = r101;
        this.backgroundStrategy = r102;
        this.enableDynamicBackground = r103;
    }

    public /* synthetic */ ResponsiveContainerOptions(boolean r100, boolean r101, BackgroundStrategy r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = true;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = BackgroundStrategy.DEFAULT;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = false;
    L14:
        this(r100, r101, r102, r103);
    }
}
