package h7b;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.bundle.ChatType;
import com.ss.android.lark.chat.base.view.vo.message.ImageContentVO;
import com.ss.android.lark.chat.component.ChatInitErrorComponent$showOpenChatError$1;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.translate.dialog.MoreTranslateActionDialog;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes35.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f484030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f484031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f484032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f484033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f484034e;

    public interface a {
        void a(String r100);

        void b(MoreTranslateActionDialog.MoreActionType r100);
    }

    public interface b {
        void onCancel();

        void onConfirm();
    }

    public static void d(Context r100, final b r101) {
        com.larksuite.component.ui.dialog.d r102 = new com.larksuite.component.ui.dialog.d(r100);
        r102.f284132c.message(R.string.Lark_Groups_CancelInvite);
        r102.a(R.id.lkui_dialog_btn_left, R.string.Lark_Legacy_CancelTip, new h7b.a(r101));
        r102.a(R.id.lkui_dialog_btn_right, R.string.Lark_Legacy_ConfirmTip, new h7b.b(r101));
        r102.i();
    }

    public static void a(ChatType r100, boolean r101, ErrorResult r102) {
        int r103 = r102.getErrorCode();
        if (r103 == 4051) goto L9;
        switch(r103) {
            case 1: goto L9;
            case 2: goto L9;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L10;
        };
    L6:
        r103 = 4;
        goto L10
    L7:
        r103 = 3;
        goto L10
    L8:
        r103 = 2;
    L10:
        Log.d("ActionUtils", "perfOpenChatFailed:" + r100 + HTTP.URL_DEFAULT + r103);
        x1b.c r104 = ChatCoreModule.a().getPerfEnterChatMonitor();
        if (r100 == null) goto L13;
        String r105 = r100.value;
    L14:
        r104.e(r105, r101, new ErrorResult(r103, r102.getDisplayMsg()));
        return;
    L13:
        r105 = "";
    L9:
        r103 = 1;
        goto L10
    }

    public static void b(Context r100, String r101, String r102) {
        com.larksuite.component.ui.dialog.d r103 = new com.larksuite.component.ui.dialog.d(r100);
        r103.f284132c.titleLineCount(2);
        r103.f284132c.titleBold(true);
        r103.k(r101);
        r103.h(r102);
        r103.a(R.id.lkui_dialog_btn_right, R.string.Lark_Group_RevokeIKnow, null);
        r103.i();
    }

    public static void c(Context r100, ErrorResult r101, ChatInitErrorComponent$showOpenChatError$1.a r102) {
        String r103 = r101.getDisplayMsg();
        int r104 = r101.getErrorCode();
        if (r104 != 1) goto L5;
        LKUIToast.show(r100, R.string.Lark_Legacy_ChatInexistent);
        return;
    L5:
        if (r104 != 2) goto L7;
        LKUIToast.show(r100, R.string.Lark_Legacy_ProfileDetailCreateSingleChatFailed);
        return;
    L7:
        if (r104 == 3) goto L29;
        if (r104 == 4) goto L22;
        if (r104 == 8) goto L22;
        if (r104 != 4051) goto L15;
        pkb.b.a(r101.getDisplayMsg(), r102);
        return;
    L15:
        if (r104 != 6002) goto L17;
        String r105 = r101.getDisplayMsg();
        com.larksuite.component.ui.dialog.d r106 = new com.larksuite.component.ui.dialog.d(r100);
        r106.k(y9c.d.i(r100, R.string.Lark_Group_GroupMemberReachLimit));
        r106.f284132c.titleBold(true);
        r106.f284132c.titleLineCount(2);
        r106.h(r105);
        r106.b(R.id.lkui_dialog_btn_right, y9c.d.i(r100, R.string.Lark_Legacy_GroupSettingMemberLimitEnsure), null);
        r106.i();
        return;
    L17:
        if (TextUtils.isEmpty(r101.getDisplayMsg()) == true) goto L35;
        LKUIToast.show(r100, r101.getDisplayMsg());
        return;
    L35:
        return;
    L22:
        if (TextUtils.isEmpty(r103) == true) goto L24;
    L27:
        pkb.b.a(r103, r102);
        return;
    L24:
        if (r101.getErrorCode() != 4) goto L26;
        r103 = UIUtils.getString(r100, R.string.Lark_IM_YouAreNotInThisChat_Text);
        goto L27
    L26:
        r103 = UIUtils.getString(r100, R.string.Lark_Education_GroupDisbandedByAdminToast);
        goto L27
    L29:
        if (TextUtils.isEmpty(r103) == false) goto L31;
        r103 = UIHelper.getString(R.string.Lark_Legacy_ChatInexistent);
    L31:
        pkb.b.a(r103, r102);
    }

    public static void e(FragmentActivity r100, ImageView r101, ImageContentVO r102) {
        if (r102 == null) goto L12;
        Image r103 = (Image) r102.f411904k.getValue();
        if (r103 != null) goto L7;
    L11:
        Log.w("ActionUtils", "thumbnail or urls is null, image key is " + ((String) r102.f411901h.getValue()));
    L13:
        r103 = null;
    L14:
        f484030a = y9c.d.a(8);
        f484031b = y9c.d.a(8);
        f484032c = y9c.d.a(40);
        f484033d = y9c.d.a(40);
        if (r103 != null) goto L17;
        Log.w("ActionUtils", "thumbnail == null");
        IRequestCreator r104 = ImageLoader.with(r100).load(Integer.valueOf(R.drawable.common_chat_window_image_item_holder));
    L21:
        r104.downloadOnly(new f(r100, r101));
        return;
    L17:
        if (r103.getKey() == null) goto L19;
        r104 = ImageLoader.with(r100).load(new EncryptImage(r103.getKey(), r103.getFsUnit(), r103.getCrypto())).dontAnimate(false).placeholder(R.drawable.common_chat_window_image_item_holder).error(R.drawable.common_failed_chat_small_picture);
        goto L21
    L19:
        Log.w("ActionUtils", "thumbnail.getKey == null");
        r104 = ImageLoader.with(r100).load(Integer.valueOf(R.drawable.common_failed_chat_small_picture));
        goto L21
    L7:
        if (r103.getKey() != null) goto L14;
        if (CollectionUtils.isNotEmpty(r103.getUrls()) == false) goto L11;
    L12:
        Log.w("ActionUtils", "ImageContent is null");
        goto L13
    }
}
