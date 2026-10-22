package com.bytedance.locallife.host.photo;

import android.content.Context;
import android.view.View;
import com.bytedance.locallife.model.album.AlbumPageInfo;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.poi.model.AlbumTabListModel;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes21.dex */
public interface b extends ns6.a {

    public static final class a {
        public static /* synthetic */ void a(b r110, Context r111, List r112, List r113, int r210, String r211, Boolean r212, Boolean r213) {
            r110.S(r111, r112, r113, r210, false, false, true, false, null, r211, r212, r213, null, null, Boolean.FALSE);
        }
    }

    void E(Context r100, List<String> r101, List<String> r102, boolean r103, boolean r104, int r105);

    void O(View r100, PoiBundle r101, String r102, int r103, int r104, boolean r105, HashMap<String, String> r106, boolean r107, String r108, String r110, boolean r111, boolean r112, String r113, List<AlbumTabListModel> r114, Boolean r115, Boolean r116, Boolean r117, String r118);

    void S(Context r100, List<String> r101, List<String> r102, int r103, boolean r104, boolean r105, boolean r106, boolean r107, String r108, String r110, Boolean r111, Boolean r112, Function0<Unit> r113, Function0<Unit> r114, Boolean r115);

    void Z(Context r100, String r101);

    void e0(int r100, String r101, HashMap r102, int r103, HashMap r104, AlbumPageInfo r105, String r106, int r107, String r108, String r110, SimpleDraweeView r111);
}
