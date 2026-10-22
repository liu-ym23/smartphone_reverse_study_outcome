package vz5;

import com.bytedance.android.livesdkapi.model.LinkMediaModel;
import com.bytedance.helios.sdk.detector.r;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import gz5.f;
import gz5.l;
import gz5.x;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f557714a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Integer> f557715b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<Integer> f557716c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<Integer> f557717d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<Integer> f557718e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<Integer> f557719f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List<x> f557720g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List<x> f557721h = null;

    static {
        List<Integer> r110 = CollectionsKt.listOf(new Integer[]{100400, 100100, 100102, Integer.valueOf(LinkMediaModel.LIVE_LINK_OPEN_ALBUM_REQUEST_CODE), 100203, 100202, 102600, 102601, 102602, 102603});
        f557714a = r110;
        List<Integer> r100 = CollectionsKt.listOf(new Integer[]{102000, 102001, 101600, 101601, 101900, 101400, 101500, 102002, 101200, 101309, 101308, 101304, 101311, 101310, 102500, 102501, 102502, 101803, 101801, 101802, 101804, 101806, 101805, 101807, 101808, 101809, 101800, 100702, 100703, 101300, 101301, 101302, 102301, 100901, 100902, 100903, 100904, 100905, 100906, 100907, 100908, 100911, 100912, 100909, 100900, 100910, 101700, 101701, 101000, 101100, 102300, 102401, 100013, 100000, 100002, 100001, 102100, 102101, 102102});
        f557715b = r100;
        List<Integer> r410 = CollectionsKt.listOf(new Integer[]{102600, 102601, 102602, 102603});
        f557716c = r410;
        List<Integer> r411 = CollectionsKt.listOf(new Integer[]{102000, 102001, 101600, 101601, 101900, 101400, 101500, 102002, 101200, 101309, 101308, 101304, 101311, 101310, 102500, 102501, 102502, 100702, 100703, 102301, 100901, 100902, 100903, 100904, 100905, 100906, 100907, 100908, 100911, 100912, 100909, 100900, 100910, 101700, 101701, 101000, 101100, 102300, 100013, 100000, 100002, 100001});
        f557717d = r411;
        List<Integer> r210 = CollectionsKt.listOf(new Integer[]{101700, 101701, 100901, 100902, 100903, 100904, 100905, 100906, 100907, 100908, 100911, 100912, 100909, 100900, 101001, 102300, 102301, 100001, 100002, 100000, 100013, 101600, 101500, 101601, 101602});
        f557718e = r210;
        List<Integer> r211 = CollectionsKt.listOf(new Integer[]{101309, 101304, 101308, 101310, 101000, 101100, 102000, 102001});
        f557719f = r211;
        f557720g = CollectionsKt.listOf(new x[]{new x("app_agreement_scene", r100, r110, null, 20), new x("guest_mode_scene", r411, r410, null, 20), new x("kids_mode_scene", r211, r210, null, 20)});
        int[] r101 = r.f245546a;
        CollectionsKt.plus(ArraysKt.asList(r101), CollectionsKt.listOf(new Integer[]{102600, 102601}));
        List r212 = CollectionsKt.listOf(new Integer[]{102600, 102601});
        Boolean r102 = Boolean.TRUE;
        CollectionsKt.listOf(new f[]{new f(r212, null, CollectionsKt.listOf(new l("$parameter && $#rule_name", MapsKt.mapOf(TuplesKt.to(ComplianceResult.JsonKey.PERMISSIONS, "[\"android.permission.ACCESS_COARSE_LOCATION\", \"android.permission.ACCESS_FINE_LOCATION\", \"android.permission.ACCESS_BACKGROUND_LOCATION\"]")), r102, 35)), null, 46), new f(ArraysKt.asList(r101), null, CollectionsKt.listOf(new l("$#rule_name", null, r102, 43)), null, 46)});
        CollectionsKt.emptyList();
        f557721h = CollectionsKt.listOf(new x[]{new x("app_agreement_overseas_scene", null, CollectionsKt.plus(ArraysKt.asList(r101), CollectionsKt.listOf(new Integer[]{102600, 102601})), CollectionsKt.listOf(new f[]{new f(CollectionsKt.listOf(new Integer[]{102600, 102601}), null, CollectionsKt.listOf(new l("$parameter && $app_agreement_overseas_scene", MapsKt.mapOf(TuplesKt.to(ComplianceResult.JsonKey.PERMISSIONS, "[\"android.permission.ACCESS_COARSE_LOCATION\", \"android.permission.ACCESS_FINE_LOCATION\", \"android.permission.ACCESS_BACKGROUND_LOCATION\"]")), r102, 35)), null, 46), new f(ArraysKt.asList(r101), null, CollectionsKt.listOf(new l("$app_agreement_overseas_scene", null, r102, 43)), null, 46)}), 6), new x("guest_mode_overseas_scene", null, CollectionsKt.plus(ArraysKt.asList(r101), CollectionsKt.listOf(new Integer[]{102600, 102601})), CollectionsKt.listOf(new f[]{new f(CollectionsKt.listOf(new Integer[]{102600, 102601}), null, CollectionsKt.listOf(new l("$parameter && $guest_mode_overseas_scene", MapsKt.mapOf(TuplesKt.to(ComplianceResult.JsonKey.PERMISSIONS, "[\"android.permission.ACCESS_COARSE_LOCATION\", \"android.permission.ACCESS_FINE_LOCATION\", \"android.permission.ACCESS_BACKGROUND_LOCATION\"]")), r102, 35)), null, 46), new f(ArraysKt.asList(r101), null, CollectionsKt.listOf(new l("$guest_mode_overseas_scene", null, r102, 43)), null, 46)}), 6), new x("kids_mode_overseas_scene", null, CollectionsKt.plus(ArraysKt.asList(r101), CollectionsKt.listOf(new Integer[]{102600, 102601})), CollectionsKt.listOf(new f[]{new f(CollectionsKt.listOf(new Integer[]{102600, 102601}), null, CollectionsKt.listOf(new l("$parameter && $kids_mode_overseas_scene", MapsKt.mapOf(TuplesKt.to(ComplianceResult.JsonKey.PERMISSIONS, "[\"android.permission.ACCESS_COARSE_LOCATION\", \"android.permission.ACCESS_FINE_LOCATION\", \"android.permission.ACCESS_BACKGROUND_LOCATION\"]")), r102, 35)), null, 46), new f(ArraysKt.asList(r101), null, CollectionsKt.listOf(new l("$kids_mode_overseas_scene", null, r102, 43)), null, 46)}), 6)});
    }
}
