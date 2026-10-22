package com.ss.android.lark.chameleon.widget.emptyview;

import android.content.Context;
import android.util.AttributeSet;
import com.larksuite.component.ud.emptystate.UDEmptyState;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes35.dex */
public class SpaceEmptyState extends UDEmptyState {
    public SpaceEmptyState(Context r100) {
        this(r100, null);
    }

    public SpaceEmptyState(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public SpaceEmptyState(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, R.style.chameleonv1_SpaceEmptyStatusStyle);
    }

    public SpaceEmptyState(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
    }
}
