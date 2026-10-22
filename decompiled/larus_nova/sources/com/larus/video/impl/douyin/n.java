package com.larus.video.impl.douyin;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.platform.uimodel.MediaEntity;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DouYinVideoDataManager f375752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f375753b;

    public final String a() {
        JSONObject r100 = new JSONObject();
        ArrayList<MediaEntity> r101 = this.f375752a.L;
        ArrayList r102 = null;
        if (r101 == null) goto L12;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r104 = r101.iterator();
    L6:
        if (r104.hasNext() == false) goto L13;
        MediaEntity r105 = (MediaEntity) r104.next();
        if (r105 == null) goto L10;
        String r106 = r105.getItem_id();
    L11:
        r103.add(r106);
        goto L6
    L10:
        r106 = null;
    L13:
        r100.put("item_id", r103);
        ArrayList<MediaEntity> r107 = this.f375752a.L;
        if (r107 == null) goto L24;
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator<T> r109 = r107.iterator();
    L17:
        if (r109.hasNext() == false) goto L23;
        MediaEntity r110 = (MediaEntity) r109.next();
        if (r110 == null) goto L21;
        String r111 = r110.getMedia_url();
    L22:
        r108.add(r111);
        goto L17
    L21:
        r111 = null;
        goto L22
    L23:
        r102 = r108;
    L24:
        r100.put("media_url", r102);
        return r100.toString();
    L12:
        r103 = null;
        goto L13
    }

    public n(DouYinVideoDataManager r100) {
        Intrinsics.checkNotNullParameter(r100, "douYinVideoDataManager");
        this.f375752a = r100;
        this.f375753b = LazyKt.lazy(new m());
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "status");
        com.larus.platform.service.o r101 = com.larus.platform.service.o.f365780a;
        JSONObject r102 = new JSONObject();
        String r103 = this.f375752a.D;
        String r104 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r102.put("bot_id", r103);
        String r105 = this.f375752a.E;
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        r102.put(MusicAppletPage.KEY_MESSAGE_ID, r105);
        String r106 = this.f375752a.A;
        if (r106 == null) goto L12;
        r104 = r106;
    L12:
        r102.put("conversation_id", r104);
        r102.put("to_status", r100);
        Unit r107 = Unit.INSTANCE;
        r101.reportEvent("click_video_player", r102);
    }
}
