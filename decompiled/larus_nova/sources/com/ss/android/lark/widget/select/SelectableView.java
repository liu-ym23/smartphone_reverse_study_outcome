package com.ss.android.lark.widget.select;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.ss.android.ugc.effectmanager.common.EffectConstants;

/* JADX INFO: loaded from: classes38.dex */
public abstract class SelectableView extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public State f448398a;

    public static final enum State extends Enum<State> {
        public static final State HIGHLIGHTED = null;
        public static final State NORMAL = null;
        public static final State SELECTED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f448399a = null;

        static {
            State r100 = new State(EffectConstants.NORMAL, 0);
            NORMAL = r100;
            State r101 = new State("SELECTED", 1);
            SELECTED = r101;
            State r102 = new State("HIGHLIGHTED", 2);
            HIGHLIGHTED = r102;
            f448399a = new State[]{r100, r101, r102};
        }

        public static State[] values() {
            return (State[]) f448399a.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public abstract CharSequence getContent();

    public abstract Layout getLayout();

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
    }

    public abstract void setContentText(CharSequence r100);

    public abstract void setHighlightedColor(int r100);

    public abstract void setSelectedColor(int r100);

    public State getState() {
        return this.f448398a;
    }

    public SelectableView(Context r100) {
        this(r100, null);
    }

    public SelectableView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public SelectableView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f448398a = State.NORMAL;
    }
}
