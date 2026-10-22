package com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields;

import androidx.collection.SparseArrayCompat;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.contact.v2.ChatWindowFields;
import com.bytedance.lark.pb.contact.v2.GetUserChatWindowFieldsRequest;
import com.bytedance.lark.pb.contact.v2.GetUserChatWindowFieldsResponse;
import com.bytedance.lark.pb.contact.v2.GetUserProfileResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.profile.v2.entity.BaseField;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import jdb.g;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class UserFieldsService implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.a f414376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f414377b;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b
    public final boolean O8() {
        boolean r100 = this.f414377b.isEnable("pc.show.user.admin.info");
        Log.i("UserFieldsService", "isUserFieldsFGEnabled=" + r100);
        return r100;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b
    public final c Eb(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        return new c(r100, false, false, null, null);
    }

    @Inject
    public UserFieldsService(com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.a r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "repository");
        Intrinsics.checkNotNullParameter(r101, "fgService");
        this.f414376a = r100;
        this.f414377b = r101;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b
    public final void X7(final String r100, IGetDataCallback<c> r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "callback");
        GetUserChatWindowFieldsRequest.Builder r102 = new GetUserChatWindowFieldsRequest.Builder().user_id(CollectionsKt.listOf(r100)).sync_data_strategy(SyncDataStrategy.FORCE_SERVER);
        com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.a r103 = this.f414376a;
        Intrinsics.checkNotNull(r102);
        r103.a(r102, r101, new UserFieldsService$forceGetServerFields$1(this, r100));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b
    public final void w3(final String r100, IGetDataCallback<c> r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "callback");
        GetUserChatWindowFieldsRequest.Builder r102 = new GetUserChatWindowFieldsRequest.Builder().user_id(CollectionsKt.listOf(r100)).sync_data_strategy(SyncDataStrategy.TRY_LOCAL);
        com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.a r103 = this.f414376a;
        Intrinsics.checkNotNull(r102);
        r103.a(r102, r101, new UserFieldsService$tryGetLocalFields$1(this, r100));
    }

    public static final c a(UserFieldsService r100, String r110, GetUserChatWindowFieldsResponse r111, boolean r112) {
        r100.getClass();
        ChatWindowFields r101 = r111.chat_window_fields.get(r110);
        if (r101 == null) goto L6;
        List<GetUserProfileResponse.Field> r102 = r101.field_orders;
        if (r102 == null) goto L6;
    L7:
        List<String> r113 = r111.old_data_user_ids;
        if ((r113 instanceof Collection) == true) goto L10;
    L12:
        Iterator<T> r114 = r113.iterator();
    L14:
        if (r114.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(r110, (String) r114.next()) == false) goto L14;
        boolean r103 = true;
    L19:
        ArrayList<BaseField> r104 = ChatCoreModule.a().getProfileDependency().parseFields(r102);
        if (r104 == null) goto L29;
        List r105 = CollectionsKt.filterNotNull(r104);
        if (r105 == null) goto L29;
        ArrayList r106 = new ArrayList();
        Iterator r107 = r105.iterator();
    L25:
        if (r107.hasNext() == false) goto L30;
        Object r108 = r107.next();
        BaseField r109 = (BaseField) r108;
        Lazy r115 = BaseFieldHandlers.f414375a;
        Intrinsics.checkNotNullParameter(r109, "<this>");
        if (((SparseArrayCompat) BaseFieldHandlers.f414375a.getValue()).containsKey(r109.getFieldType()) == false) goto L25;
        r106.add(r108);
    L30:
        if (r106 == null) goto L34;
        BaseField r116 = (BaseField) CollectionsKt.firstOrNull(r106);
        if (r116 == null) goto L34;
        String r117 = BaseFieldHandlers.a(r116);
    L35:
        if (r106 == null) goto L39;
        BaseField r118 = (BaseField) CollectionsKt.getOrNull(r106, 1);
        if (r118 == null) goto L39;
        String r119 = BaseFieldHandlers.a(r118);
    L40:
        if (r112 == true) goto L43;
        if (r103 == false) goto L43;
        boolean r120 = true;
    L45:
        return new c(r110, r120, r103, r117, r119);
    L43:
        r120 = false;
    L39:
        r119 = null;
    L34:
        r117 = null;
    L29:
        r106 = null;
    L18:
        r103 = false;
        goto L19
    L10:
        if (r113.isEmpty() == false) goto L12;
    L6:
        r102 = CollectionsKt.emptyList();
        goto L7
    }
}
