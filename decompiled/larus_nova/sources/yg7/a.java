package yg7;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.timon.permission.storage.constant.ResultCode;
import com.bytedance.timon.permission.storage.constant.TimonMediaType;
import com.bytedance.timon.permission.storage.manager.TimonMediaInternal;
import com.dtf.face.ui.toyger.FaceShowElderlyFragment;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f567506a = 0;

    /* JADX INFO: renamed from: yg7.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C8340a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f567507a = null;

        static {
            int[] r100 = new int[TimonMediaType.values().length];
            r100[TimonMediaType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[TimonMediaType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[TimonMediaType.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f567507a = r100;
        }
    }

    static {
    }

    public static void a(Activity r110, Intent r111, TimonMediaInternal.a r112, TimonMediaType r113) {
        if ((r110 instanceof FragmentActivity) == false) goto L54;
        FragmentActivity r114 = (FragmentActivity) r110;
        if (r111 != null) goto L8;
        r111 = new Intent();
    L8:
        if (r111.getAction() != null) goto L20;
        int r100 = C8340a.f567507a[r113.ordinal()];
        if (r100 == 1) goto L17;
        if (r100 == 2) goto L16;
        if (r100 != 3) goto L15;
        String r101 = "android.provider.MediaStore.RECORD_SOUND";
    L18:
        r111.setAction(r101);
        goto L20
    L15:
        throw new NoWhenBranchMatchedException();
    L16:
        r101 = "android.media.action.VIDEO_CAPTURE";
        goto L18
    L17:
        r101 = "android.media.action.IMAGE_CAPTURE";
    L20:
        if (r111.hasExtra(BdpAppEventConstant.PARAMS_OUTPUT) == true) goto L49;
        int r102 = com.bytedance.timon.permission.storage.util.c.f270671a;
        String r103 = new SimpleDateFormat("yyyy-MM-dd-HHmmss", Locale.getDefault()).format(Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).getTime());
        Intrinsics.checkNotNullParameter(r114, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "fileName");
        Intrinsics.checkNotNullParameter(r113, "type");
        int[] r104 = com.bytedance.timon.permission.storage.util.c.a.f270672a;
        int r105 = r104[r113.ordinal()];
        if (r105 == 1) goto L29;
        if (r105 == 2) goto L28;
        if (r105 != 3) goto L27;
        File r106 = r114.getExternalFilesDir(Environment.DIRECTORY_ALARMS);
    L30:
        int r107 = r104[r113.ordinal()];
        if (r107 == 1) goto L38;
        if (r107 == 2) goto L37;
        if (r107 != 3) goto L36;
        String r108 = "AUDIO_" + r103 + '_';
    L39:
        int r115 = r104[r113.ordinal()];
        if (r115 == 1) goto L47;
        if (r115 == 2) goto L46;
        if (r115 != 3) goto L45;
        String r116 = FaceShowElderlyFragment.AUDIO_FORM;
    L48:
        r111.putExtra(BdpAppEventConstant.PARAMS_OUTPUT, FileProvider.getUriForFile(r114, r114.getPackageName() + ".timon.media.file.provider.authority", File.createTempFile(r108, r116, r106)));
        goto L49
    L45:
        throw new NoWhenBranchMatchedException();
    L46:
        r116 = ".mp4";
        goto L48
    L47:
        r116 = ".jpg";
        goto L48
    L36:
        throw new NoWhenBranchMatchedException();
    L37:
        r108 = "VIDEO_" + r103 + '_';
        goto L39
    L38:
        r108 = "JPEG_" + r103 + '_';
        goto L39
    L27:
        throw new NoWhenBranchMatchedException();
    L28:
        r106 = r114.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
        goto L30
    L29:
        r106 = r114.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
    L49:
        Bundle r117 = r111.getExtras();
        if (r117 == null) goto L52;
        Object r118 = r117.get(BdpAppEventConstant.PARAMS_OUTPUT);
    L53:
        Intrinsics.checkNotNull(r118, "null cannot be cast to non-null type android.net.Uri");
        com.bytedance.timon.result.d.startActivityForResult(r114, r111, null, new c(r112, (Uri) r118));
        return;
    L52:
        r118 = null;
        goto L53
    L54:
        r112.a(ResultCode.ArgumentError.getValue(), null, "context 不是一个 FragmentActivity");
    }
}
