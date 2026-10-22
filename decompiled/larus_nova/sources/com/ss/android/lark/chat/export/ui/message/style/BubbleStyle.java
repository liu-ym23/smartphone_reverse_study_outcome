package com.ss.android.lark.chat.export.ui.message.style;

import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes35.dex */
public final class BubbleStyle {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final BubbleStyle f415420h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f415421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<View> f415422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f415423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f415424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f415425e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f415426f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f415427g;

    public @interface ColorType {
        public static final int BLUE = 0;
        public static final int BLUE_BORDER = 8;
        public static final int BLUE_HEADER_WHITE_BORDER = 101;
        public static final int BLUE_WHITE_BORDER = 3;
        public static final int CARD_CELL_DEFAULT_NO_BORDER = 16;
        public static final int CARD_WHITE = 17;
        public static final int CARMINE_HEADER_WHITE_BORDER = 109;
        public static final int FLOAT_WHITE = 12;
        public static final int FLOAT_WHITE_AND_HEADER_CUSTOM = 13;
        public static final int FLOAT_WHITE_PIN = 19;
        public static final int GREEN_HEADER_WHITE_BORDER = 104;
        public static final int GREY = 1;
        public static final int GREY_BORDER = 7;
        public static final int GREY_WHITE_BORDER = 4;
        public static final int INDIGO_HEADER_WHITE_BORDER = 112;
        public static final int LIME_HEADER_WHITE_BORDER = 105;
        public static final int NEUTRAL_BORDER = 15;
        public static final int NEUTRAL_BORDER_PIN = 18;
        public static final int NEUTRAL_HEADER_WHITE_BORDER = 100;
        public static final int NEUTRAL_WHITE_BORDER = 14;
        public static final int NONE = 9;
        public static final int ORANGE_HEADER_WHITE_BORDER = 107;
        public static final int PURPLE_HEADER_WHITE_BORDER = 111;
        public static final int RED_HEADER_WHITE_BORDER = 108;
        public static final int SINGLE_URL_CARD = 113;
        public static final int SINGLE_URL_CARD_IN_THREAD_CHAT = 114;
        public static final int SINGLE_URL_CARD_WITH_THREAD_REPLY = 115;
        public static final int STATIC_WHITE = 10;
        public static final int STATIC_WHITE_AND_HEADER_CUSTOM = 11;
        public static final int TURQUOISE_HEADER_WHITE_BORDER = 103;
        public static final int VIOLET_HEADER_WHITE_BORDER = 110;
        public static final int WATHET_HEADER_WHITE_BORDER = 102;
        public static final int WHITE = 2;
        public static final int WHITE_AND_HEADER_CUSTOM = 6;
        public static final int YELLOW_HEADER_WHITE_BORDER = 106;
    }

    public final void b() {
        this.f415421a = new int[]{0, 0, 0, 0};
    }

    static {
        f415420h = new BubbleStyle();
    }

    public BubbleStyle() {
        this.f415423c = -1;
        this.f415424d = -1;
    }

    public static void a(int r100, View r101, int[] r102) {
        BubbleStyle r103 = f415420h;
        r103.f415422b = null;
        r103.f415425e = 0;
        r103.f415426f = 0;
        r103.b();
        r103.f415423c = -1;
        r103.f415424d = -1;
        r103.f415427g = false;
        r103.f415425e = r100;
        r103.f415422b = new WeakReference(r101);
        if (r102.length == 4) goto L5;
        r103.b();
        return;
    L5:
        r103.f415421a = r102;
    }
}
