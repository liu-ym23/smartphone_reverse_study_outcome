package com.ss.android.lark.officewebview.dependency;

import com.ss.android.lark.officesdk.di.core.b;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public interface IDevicePermissionDependency extends b {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/officewebview/dependency/IDevicePermissionDependency$CameraPermissionScene;", "", "<init>", "(Ljava/lang/String;I)V", "FILE_CHOOSE_V2", "webview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CameraPermissionScene extends Enum<CameraPermissionScene> {
        public static final CameraPermissionScene FILE_CHOOSE_V2 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CameraPermissionScene[] f437467a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f437468b = null;

        public static EnumEntries<CameraPermissionScene> getEntries() {
            return f437468b;
        }

        static {
            CameraPermissionScene r100 = new CameraPermissionScene();
            FILE_CHOOSE_V2 = r100;
            CameraPermissionScene[] r101 = {r100};
            f437467a = r101;
            f437468b = EnumEntriesKt.enumEntries(r101);
        }

        public CameraPermissionScene() {
            super("FILE_CHOOSE_V2", 0);
        }

        public static CameraPermissionScene[] values() {
            return (CameraPermissionScene[]) f437467a.clone();
        }

        public static CameraPermissionScene valueOf(String r100) {
            return (CameraPermissionScene) a.a(CameraPermissionScene.class, r100);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/officewebview/dependency/IDevicePermissionDependency$MediaScannerAction;", "", "<init>", "(Ljava/lang/String;I)V", "FILE_CHOOSE_V2", "webview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum MediaScannerAction extends Enum<MediaScannerAction> {
        public static final MediaScannerAction FILE_CHOOSE_V2 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MediaScannerAction[] f437469a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f437470b = null;

        public static EnumEntries<MediaScannerAction> getEntries() {
            return f437470b;
        }

        static {
            MediaScannerAction r100 = new MediaScannerAction();
            FILE_CHOOSE_V2 = r100;
            MediaScannerAction[] r101 = {r100};
            f437469a = r101;
            f437470b = EnumEntriesKt.enumEntries(r101);
        }

        public MediaScannerAction() {
            super("FILE_CHOOSE_V2", 0);
        }

        public static MediaScannerAction[] values() {
            return (MediaScannerAction[]) f437469a.clone();
        }

        public static MediaScannerAction valueOf(String r100) {
            return (MediaScannerAction) a.a(MediaScannerAction.class, r100);
        }
    }

    String m0();

    boolean o0();
}
