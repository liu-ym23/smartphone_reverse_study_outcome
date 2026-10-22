package rg5;

import com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.AskOwnerHelper;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.IModel;
import io.reactivex.Flowable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface g extends IModel {
    ArrayList<UserInfo> K7();

    Flowable<AskOwnerHelper.AskOwnerSendResult> U6(int r1, String r2);
}
