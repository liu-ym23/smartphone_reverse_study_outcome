package dgb;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chatwindow.launcher.c;
import com.ss.android.lark.create.groupchat.dto.CreateGroupScene;
import com.ss.android.lark.create.groupchat.dto.GroupCreateInfo;
import com.ss.android.lark.create.groupchat.impl.service.h;
import com.ss.android.lark.flow.chat.creategroup.page.FlowGroupCreateActivity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import dagger.hilt.android.EntryPointAccessors;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f468547d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Inject
    public h f468548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Inject
    public c f468549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Inject
    public hab.b f468550c;

    /* JADX INFO: renamed from: dgb.a$a, reason: collision with other inner class name */
    public static final class C5667a {
        public static a a() {
            return ((b) EntryPointAccessors.fromApplication(LarkContext.getApplication(), b.class)).d();
        }
    }

    static {
    }

    @Inject
    public a() {
    }

    public static void a(FragmentActivity r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "chatId");
        Intent r102 = new Intent(r100, FlowGroupCreateActivity.class);
        PassportcConvention.e(r102, LarkContext.getApplication());
        Bundle r103 = new Bundle();
        r103.putString("key_group_create_scene", "group_create_scene_p2p_chat");
        r103.putString("key_group_create_chat_id", r101);
        r102.putExtras(r103);
        r100.startActivity(r102);
        Log.d("FlowCreateGroupChatModule", "createGroupFromP2PChat");
    }

    public final void b(Context r110, GroupCreateInfo r111, List<? extends SearchBaseInfo> r112, IGetDataCallback<Chat> r113, CreateGroupScene r114, IGetDataCallback<w5b.a> r115, Fragment r116) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "groupCreateInfo");
        Intrinsics.checkNotNullParameter(r112, "searchInfos");
        Intrinsics.checkNotNullParameter(r114, "source");
        h r100 = this.f468548a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("createGroupService");
        r100 = null;
    L6:
        hab.b r101 = this.f468550c;
        if (r101 == null) goto L9;
        hab.b r117 = r101;
    L10:
        r100.Da(r110, r111, r112, r113, r114, r115, r116, r117);
        return;
    L9:
        Intrinsics.throwUninitializedPropertyAccessException("chatDependency");
        r117 = null;
        goto L10
    }
}
