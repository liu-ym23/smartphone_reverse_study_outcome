package tib;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.forwardv3.configuration.dto.StickImage;
import com.ss.android.lark.forwardv3.dependency.ExternalForwardDirection;
import com.ss.android.lark.forwardv3.dependency.IExternalForwardExecutor;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public interface g {
    void attachGlobalWatermark(Dialog r100);

    c createForwardChatPicker(Context r100);

    String getAppLinkDomain();

    Map<String, Chatter> getChatterMap(Map<String, com.bytedance.lark.pb.basic.v1.Chatter> r100);

    String getCreateGroupChatResultKey();

    String getCreateGroupSelectedDataKey();

    zib.a getEventParams(List<String> r100);

    IExternalForwardExecutor getExternalForwardExecutor(ExternalForwardDirection r100, String r101, List<String> r102, String r103, boolean r104, String r105);

    String getExternalTargetId();

    a getExternalTargetItem();

    int getLoginUserAuthorityDeniedReason();

    String getLoginUserId();

    void go2Chat(Context r100, String r101, Bundle r102);

    void go2Chat(Context r100, String r101, Chat.ChatMode r102, Bundle r103);

    void go2Thread(Context r100, String r101);

    boolean hasFilePreviewPermissionFromMessage(Message r100);

    boolean isDoubaoWorkTabEnabled();

    boolean isEnterSendEnabled();

    void showNoIMPermissionDialog(String r100);

    void showSquareMessageStickerThumb(Context r100, ImageView r101, StickImage r102);

    void startCreateGroup(Fragment r100, boolean r101, int r102);

    void startCreateGroupWithFilter(Context r100, Fragment r101, Bundle r102, IGetDataCallback<Chat> r103);

    void startProfile(Context r100, String r101);
}
