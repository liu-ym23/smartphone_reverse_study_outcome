package com.facebook.keyframes.model.keyframedmodels;

import android.graphics.Color;
import com.alibaba.gaiax.model.GXAnimation;
import com.facebook.keyframes.model.HasKeyFrame;
import com.facebook.keyframes.model.KFColorFrame;
import com.facebook.keyframes.model.KFGradientColor;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class KeyFramedGradient extends KeyFramedObject<KFColorFrame, GradientColorPair> {
    private final Position mPosition;

    public static class GradientColorPair {
        private int mEndColor;
        private int mStartColor;

        public GradientColorPair() {
        }

        public int getEndColor() {
            return this.mEndColor;
        }

        public int getStartColor() {
            return this.mStartColor;
        }

        private void setEndColor(int r100) {
            this.mEndColor = r100;
        }

        private void setStartColor(int r100) {
            this.mStartColor = r100;
        }

        public static /* synthetic */ void access$000(GradientColorPair r100, int r101) {
            r100.setStartColor(r101);
        }

        public static /* synthetic */ void access$100(GradientColorPair r100, int r101) {
            r100.setEndColor(r101);
        }
    }

    public static final enum Position extends Enum<Position> {
        private static final /* synthetic */ Position[] $VALUES = null;
        public static final Position END = null;
        public static final Position START = null;

        static {
            Position r100 = new Position(GXAnimation.STATE_START, 0);
            START = r100;
            Position r101 = new Position(GXAnimation.STATE_END, 1);
            END = r101;
            $VALUES = new Position[]{r100, r101};
        }

        public static Position[] values() {
            return (Position[]) $VALUES.clone();
        }

        public static Position valueOf(String r100) {
            return (Position) Enum.valueOf(Position.class, r100);
        }

        private Position(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static KeyFramedGradient fromGradient(KFGradientColor r100, Position r101) {
        return new KeyFramedGradient(r100.getKeyValues(), r100.getTimingCurves(), r101);
    }

    private KeyFramedGradient(List<KFColorFrame> r100, float[][][] r101, Position r102) {
        super(r100, r101);
        this.mPosition = r102;
    }

    public static int getTransitionColor(float r100, int r101, int r102) {
        int r103 = Color.alpha(r101);
        int r104 = Color.red(r101);
        int r105 = Color.green(r101);
        int r106 = Color.blue(r101);
        return ((((r103 + ((int) ((Color.alpha(r102) - r103) * r100))) << 24) | ((r104 + ((int) ((Color.red(r102) - r104) * r100))) << 16)) | ((r105 + ((int) ((Color.green(r102) - r105) * r100))) << 8)) | (r106 + ((int) (r100 * (Color.blue(r102) - r106))));
    }

    public void applyImpl(KFColorFrame r100, KFColorFrame r101, float r102, GradientColorPair r103) {
        if (r101 != null) goto L9;
        if (this.mPosition != Position.START) goto L6;
        GradientColorPair.access$000(r103, r100.getColor());
        return;
    L6:
        GradientColorPair.access$100(r103, r100.getColor());
        return;
    L9:
        if (this.mPosition != Position.START) goto L11;
        GradientColorPair.access$000(r103, getTransitionColor(r102, r100.getColor(), r101.getColor()));
        return;
    L11:
        GradientColorPair.access$100(r103, getTransitionColor(r102, r100.getColor(), r101.getColor()));
    }

    @Override // com.facebook.keyframes.model.keyframedmodels.KeyFramedObject
    public /* bridge */ /* synthetic */ void applyImpl(HasKeyFrame r100, HasKeyFrame r101, float r102, GradientColorPair r103) {
        applyImpl((KFColorFrame) r100, (KFColorFrame) r101, r102, r103);
    }
}
