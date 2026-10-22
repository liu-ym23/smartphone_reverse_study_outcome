package com.ss.android.ugc.aweme.live.alphaplayer.render;

import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import com.ss.android.ugc.aweme.live.alphaplayer.model.Rect;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/live/alphaplayer/render/LayersRenderer;", "", "alpha_player_release"}, k = 1, mv = {1, 4, 0})
public final class LayersRenderer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, DataSource.Layer> f451208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<String> f451209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Rect f451210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f451211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f451212e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AlphaVideoProgram f451213f;

    public LayersRenderer(List<DataSource.Layer> r100, AlphaVideoProgram r101) {
        this.f451213f = r101;
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        DataSource.Layer r104 = (DataSource.Layer) r103.next();
        r102.put(r104.f451147a, r104);
        goto L4
    L6:
        this.f451208a = r102;
        ArrayList r105 = new ArrayList(r102.size());
        Iterator r106 = r102.entrySet().iterator();
    L8:
        if (r106.hasNext() == false) goto L14;
        DataSource.MaskContainer r107 = ((DataSource.Layer) ((Map.Entry) r106.next()).getValue()).f451152f;
        if (r107 == null) goto L12;
        String r108 = r107.f451153a;
    L13:
        r105.add(r108);
        goto L8
    L12:
        r108 = null;
        goto L13
    L14:
        this.f451209b = CollectionsKt.toHashSet(CollectionsKt.filterNotNull(r105));
        Rect.f451168g.getClass();
        this.f451210c = Rect.f451167f;
        DataSource.ScaleType r109 = DataSource.ScaleType.ScaleToFill;
    }
}
