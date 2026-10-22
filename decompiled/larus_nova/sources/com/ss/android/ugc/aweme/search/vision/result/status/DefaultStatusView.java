package com.ss.android.ugc.aweme.search.vision.result.status;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.search.vision.result.panel.PhotoSearchBottomPanelViewModel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class DefaultStatusView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<View> f453763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f453764b;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f453765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f453766b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public View f453767c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public View f453768d;

        public Builder(Context r100) {
            if (r100 == null) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("DmtStatusView.Builder:Context can not be null");
        }
    }

    public void setPanelViewModel(PhotoSearchBottomPanelViewModel r100) {
    }

    public DefaultStatusView(Context r100) {
        super(r100);
        this.f453763a = new ArrayList(5);
        this.f453764b = -1;
    }

    public final View a(int r100) {
        if (r100 >= 0) goto L4;
        return null;
    L4:
        if (r100 < this.f453763a.size()) goto L7;
        return null;
    L7:
        return (View) ListProtector.get(this.f453763a, r100);
    }

    public void setStatus(int r100) {
        int r101 = this.f453764b;
        if (r101 != r100) goto L6;
        return;
    L6:
        if (r101 < 0) goto L10;
        View r102 = a(r101);
        if (r102 == null) goto L10;
        r102.setVisibility(4);
    L10:
        if (r100 < 0) goto L14;
        setVisibility(0);
        View r103 = a(r100);
        if (r103 == null) goto L15;
        r103.setVisibility(0);
    L15:
        this.f453764b = r100;
        return;
    L14:
        setVisibility(4);
        goto L15
    }

    public DefaultStatusView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f453763a = new ArrayList(5);
        this.f453764b = -1;
    }
}
