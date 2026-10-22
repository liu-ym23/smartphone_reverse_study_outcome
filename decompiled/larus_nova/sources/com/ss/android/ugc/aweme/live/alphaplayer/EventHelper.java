package com.ss.android.ugc.aweme.live.alphaplayer;

import android.view.MotionEvent;
import android.view.View;
import com.ss.android.ugc.aweme.live.alphaplayer.render.IRender;
import com.ss.android.ugc.aweme.live.alphaplayer.render.VideoRenderer;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/live/alphaplayer/EventHelper;", "", "alpha_player_release"}, k = 1, mv = {1, 4, 0})
public final class EventHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IRender f451013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<List<String>, Unit> f451014b;

    /* JADX WARN: Multi-variable type inference failed */
    public EventHelper(IRender r100, Function1<? super List<String>, Unit> r101) {
        this.f451013a = r100;
        this.f451014b = r101;
    }

    public final boolean a(View r100, MotionEvent r101) {
        int r102 = r101.getAction();
        if (r102 == 0) goto L20;
        if (r102 != 1) goto L6;
        IRender r103 = this.f451013a;
        VideoRenderer r104 = (VideoRenderer) r103;
        List<String> r105 = r104.d(new TouchEvent((int) (r101.getX() - r100.getX()), (int) (r101.getY() - r100.getY()), r100.getMeasuredWidth(), r100.getMeasuredHeight()));
        if (r105 != null) goto L14;
    L17:
        boolean r106 = true;
    L18:
        if (r106 == true) goto L30;
        Objects.toString(r105);
        this.f451014b.invoke(r105);
    L10:
        return true;
    L30:
        return false;
    L14:
        if (r105.isEmpty() == true) goto L17;
        r106 = false;
        goto L18
    L6:
        if (r102 == 2) goto L10;
        if (r102 == 3) goto L10;
        return false;
    L20:
        IRender r107 = this.f451013a;
        VideoRenderer r108 = (VideoRenderer) r107;
        List<String> r109 = r108.d(new TouchEvent((int) (r101.getX() - r100.getX()), (int) (r101.getY() - r100.getY()), r100.getMeasuredWidth(), r100.getMeasuredHeight()));
        if (r109 != null) goto L23;
    L26:
        boolean r110 = true;
    L27:
        if (r110 == false) goto L10;
        return false;
    L23:
        if (r109.isEmpty() == true) goto L26;
        r110 = false;
        goto L27
    }
}
