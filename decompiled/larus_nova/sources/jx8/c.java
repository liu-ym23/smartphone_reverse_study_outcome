package jx8;

import com.larus.camera.api.params.CaptureMode;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.api.params.InputParamExtra;
import com.larus.platform.model.camera.ICameraEventExt;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f500890a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.larus.camera.api.params.InputParam] */
    public static InputParam a(hx8.a r100, ICameraEventExt r101) {
        Intrinsics.checkNotNullParameter(r100, "cameraConfig");
        List<Pair<String, String>> r102 = r100.f487524c;
        if (r102 == null) goto L8;
        List<Pair<String, String>> r103 = r102;
        ?? r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L6:
        if (r105.hasNext() == false) goto L9;
        Pair r106 = (Pair) r105.next();
        r104.add(new CaptureMode((String) r106.getFirst(), (String) r106.getSecond()));
    L9:
        if (r104 != 0) goto L11;
        r104 = CollectionsKt.emptyList();
    L11:
        InputParamExtra r107 = new InputParamExtra();
        r107.putAll(r100.f487526e);
        String r108 = r100.f487543v;
        if (r108 == null) goto L14;
        r107.put("SUGGESTION_PREFIX", r108);
    L14:
        r107.put("SHOW_BOTTOM_ALBUM", String.valueOf(r100.f487544w));
        String r109 = r100.f487522a;
        Intrinsics.checkNotNullParameter(r109, "scene");
        ?? r110 = new InputParam(null);
        r110.setScene(r109);
        String r111 = r100.f487523b;
        Intrinsics.checkNotNullParameter(r111, "captureMode");
        ?? r112 = r104;
        if (r104 != 0) goto L17;
        r112 = CollectionsKt.emptyList();
    L17:
        r110.setCaptureModeList(r112);
        r110.setCaptureMode(r111);
        Intrinsics.checkNotNullParameter("FLASH_MODE_AUTO", "flashMode");
        r110.setFlashMode("FLASH_MODE_AUTO");
        r110.setFrontCamera(false);
        Intrinsics.checkNotNullParameter("TARGET_SHOW_GET", PickerReporterConstants.KEY.TARGET);
        r110.setTarget("TARGET_SHOW_GET");
        r110.setEventExt(r101);
        r110.setEnableCaptureDetectModeList(r100.f487527f);
        r110.setCameraNameUrl(r100.f487528g);
        r110.setCameraName(r100.f487529h);
        r110.setTipsShowOrder(r100.f487530i);
        r110.setTips(r100.f487531j);
        r110.setSupportCrop(r100.f487533l);
        r110.setSupportMark(r100.f487532k);
        r110.setSupportMultiImages(r100.f487534m);
        r110.setBotId(r100.f487535n);
        r110.setEnableFocusFrame(r100.f487536o);
        r110.setInputStyle(r100.f487537p);
        r110.setSupportRecord(r100.f487538q);
        r110.setAlbumLandingTabIndex(r100.f487539r);
        r110.setAddedAttachmentCount(r100.f487540s);
        r110.setSupportAlbumMultiTake(r100.f487541t);
        r110.setAlbumMultiTakeMaxCount(r100.f487542u);
        r110.setAlbumSupportOriginalImage(r100.f487545x);
        r110.setEnableCaptureAlbum(r100.f487547z);
        r110.setEnableOriginalImageDeferredEdit(r100.f487546y);
        String r113 = r100.A;
        List<String> r114 = r100.B;
        Intrinsics.checkNotNullParameter(r113, "text");
        Intrinsics.checkNotNullParameter(r114, "attachmentUris");
        r110.setAlbumInputText(r113);
        r110.setAlbumAttachmentUris(r114);
        r110.setResultRoute(r100.C);
        r110.setInitialOutputContext(r100.D);
        r110.setExtra(r107);
        return r110;
    L8:
        r104 = 0;
        goto L9
    }
}
