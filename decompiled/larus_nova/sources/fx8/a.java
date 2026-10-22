package fx8;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f479110a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f479111b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f479112c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<String> f479113d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<String> f479114e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<String> f479115f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List<String> f479116g = null;

    static {
        List<String> r100 = CollectionsKt.listOf("CAPTURE_MODE_PHOTO");
        f479110a = r100;
        List<String> r101 = CollectionsKt.listOf("CAPTURE_MODE_SCAN");
        f479111b = r101;
        List<String> r102 = CollectionsKt.listOf(new String[]{"CAPTURE_MODE_HEALTH_PHOTO", "CAPTURE_MODE_HEALTH_SECOND_PHOTO"});
        f479112c = r102;
        f479113d = CollectionsKt.listOf("CAPTURE_MODE_EDU_GENERAL_PHOTO");
        List<String> r103 = CollectionsKt.listOf(new String[]{"CAPTURE_MODE_EDU_GENERAL_PHOTO", "CAPTURE_MODE_EDU_ARTICLE_PHOTO", "CAPTURE_MODE_EDU_CALCULATION_PHOTO", "CAPTURE_MODE_EDU_HOMEWORK_PHOTO"});
        f479114e = r103;
        f479115f = CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(r100, r101), r103), r102);
        f479116g = CollectionsKt.listOf(new String[]{"common_input", "outer_input", "common_bottom_menu", "send_photo_preview"});
    }
}
