package com.ss.android.ugc.aweme.kiwi.util;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.Metadata;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/kiwi/util/QUtils;", "", "<init>", "()V", "kiwi_release"}, k = 1, mv = {1, 4, 0})
public final class QUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final QUtils f450935a = null;

    private QUtils() {
    }

    static {
        f450935a = new QUtils();
    }

    public static void a(ViewGroup r100, ViewStub r101, ViewGroup.LayoutParams r102, QUIModule r103) {
        int r104 = r100.indexOfChild(r101);
        r100.removeViewInLayout(r101);
        if (r102 == null) goto L9;
        Object r105 = r101.getTag(-2);
        if (r105 == null) goto L8;
        r100.addView((View) r105, r104, r102);
    L12:
        r103.f450923g = (View) r101.getTag(-2);
        r101.setTag(-2, null);
        return;
    L8:
        throw new TypeCastException("null cannot be cast to non-null type android.view.View");
    L9:
        Object r106 = r101.getTag(-2);
        if (r106 == null) goto L15;
        r100.addView((View) r106, r104);
        goto L12
    L15:
        throw new TypeCastException("null cannot be cast to non-null type android.view.View");
    }
}
