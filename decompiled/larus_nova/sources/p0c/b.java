package p0c;

import android.os.Bundle;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes37.dex */
public final class b {
    public static Bundle a(String r100, String r101, String r102, String r103, String r104, String r105) {
        Log.i("PhotoEditorLauncher", "startPhotoEditor: " + ("imagePath=" + r100 + ",resultPath=" + r101 + ",from=" + r102 + ",showSaveBtn=true,showForwardBtn=false,fileKey=" + r103 + ",chatId=" + r104 + ",messageId=" + r105 + ",presetMaskRects=-1"));
        Bundle r106 = new Bundle();
        r106.putString("key_image_url", r100);
        r106.putString("key_result_path", r101);
        r106.putString("key_from", r102);
        r106.putBoolean("key_show_save_btn", true);
        r106.putBoolean("key_show_forward_btn", false);
        r106.putString("key_file_key", r103);
        r106.putString("chat_id", r104);
        r106.putString(MusicAppletPage.KEY_MESSAGE_ID, r105);
        if (CollectionUtils.isEmpty(null) == true) goto L5;
        r106.putParcelableArrayList("key_preset_mask_rects", new ArrayList(null));
    L5:
        return r106;
    }
}
