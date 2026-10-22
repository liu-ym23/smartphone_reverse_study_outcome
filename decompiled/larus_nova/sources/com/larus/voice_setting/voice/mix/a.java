package com.larus.voice_setting.voice.mix;

import android.widget.ImageView;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: classes32.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.voice_setting.voice.mix.a$a, reason: collision with other inner class name */
    public static final class C4521a {
        public static void a(a r100, int r101) {
            if (r101 != 1) goto L5;
            ImageView r102 = r100.getPlayIcon();
            if (r102 == null) goto L36;
            r102.setVisibility(8);
        L36:
            LottieAdapterView r103 = r100.getPlayLottieView();
            if (r103 == null) goto L39;
            r103.setVisibility(0);
        L39:
            LottieAdapterView r104 = r100.getPlayLottieView();
            if (r104 == null) goto L42;
            r104.cancelAnimation();
        L42:
            LottieAdapterView r105 = r100.getPlayLottieView();
            if (r105 == null) goto L45;
            r105.setAnimation("lottie/text_msg_voice_playing.json");
        L45:
            LottieAdapterView r106 = r100.getPlayLottieView();
            if (r106 == null) goto L53;
            r106.playAnimation();
            return;
        L53:
            return;
        L5:
            if (r101 != 2) goto L7;
            ImageView r107 = r100.getPlayIcon();
            if (r107 == null) goto L21;
            r107.setVisibility(8);
        L21:
            LottieAdapterView r108 = r100.getPlayLottieView();
            if (r108 == null) goto L24;
            r108.setVisibility(0);
        L24:
            LottieAdapterView r109 = r100.getPlayLottieView();
            if (r109 == null) goto L27;
            r109.cancelAnimation();
        L27:
            LottieAdapterView r110 = r100.getPlayLottieView();
            if (r110 == null) goto L30;
            r110.setAnimation("lottie/text_msg_voice_loading.json");
        L30:
            LottieAdapterView r111 = r100.getPlayLottieView();
            if (r111 == null) goto L51;
            r111.playAnimation();
            return;
        L51:
            return;
        L7:
            if (r101 != 3) goto L54;
            ImageView r112 = r100.getPlayIcon();
            if (r112 == null) goto L12;
            r112.setVisibility(0);
        L12:
            LottieAdapterView r113 = r100.getPlayLottieView();
            if (r113 == null) goto L15;
            r113.setVisibility(8);
        L15:
            LottieAdapterView r114 = r100.getPlayLottieView();
            if (r114 == null) goto L49;
            r114.cancelAnimation();
            return;
        L49:
            return;
        }
    }

    ImageView getPlayIcon();

    LottieAdapterView getPlayLottieView();
}
