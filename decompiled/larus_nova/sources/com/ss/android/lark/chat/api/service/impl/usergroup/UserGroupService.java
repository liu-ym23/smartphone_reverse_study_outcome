package com.ss.android.lark.chat.api.service.impl.usergroup;

import a2b.o;
import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.im.v1.GetUserGroupEntitiesRequest;
import com.bytedance.lark.pb.im.v1.GetUserGroupEntitiesResponse;
import com.bytedance.lark.pb.im.v1.UserGroupEntity;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.facebook.keyframes.model.KFAnimation;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.thread.n;
import com.larus.nova.R;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.s;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.span.AtUserGroupInfo;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.inject.Inject;
import jdb.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class UserGroupService implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f411676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f411677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f411678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<Long, UserGroupEntity> f411679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<com.ss.android.lark.biz.im.api.usergroup.a, Object> f411680e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ReentrantReadWriteLock f411681f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f411682g;

    public static final class a {
    }

    static {
    }

    public final boolean a() {
        return ((Boolean) this.f411682g.getValue()).booleanValue();
    }

    @Override // a2b.o
    public final boolean isEnabled() {
        return a();
    }

    @Override // a2b.o
    public final void La(Message r100) {
        if (a() == true) goto L5;
        return;
    L5:
        int r101 = c.f411684a;
        c.b("UserGroupService", "injectUserGroups, message id: " + r100.getId());
        Content r102 = r100.getContent();
        if ((r102 instanceof BaseTextContent) == true) goto L8;
        return;
    L8:
        RichText r103 = ((BaseTextContent) r102).getRichText();
        if (r103 != null) goto L11;
        return;
    L11:
        c6(r103, r100.getId());
    }

    @Override // a2b.o
    public final void pe(Map<Long, UserGroupEntity> r210) {
        Intrinsics.checkNotNullParameter(r210, "userGroups");
        if (a() == true) goto L6;
        return;
    L6:
        if (r210.isEmpty() == false) goto L8;
        return;
    L8:
        int r100 = c.f411684a;
        c.b("UserGroupService", "updateUserGroup: " + r210.keySet());
        LinkedHashMap r101 = new LinkedHashMap();
        ReentrantReadWriteLock r102 = this.f411681f;
        ReentrantReadWriteLock.ReadLock r103 = r102.readLock();
        if (r102.getWriteHoldCount() != 0) goto L11;
        int r104 = r102.getReadHoldCount();
    L12:
        int r105 = 0;
    L13:
        if (r105 >= r104) goto L15;
        r103.unlock();
        r105 = r105 + 1;
        goto L13
    L15:
        ReentrantReadWriteLock.WriteLock r106 = r102.writeLock();
        r106.lock();
        Iterator<Map.Entry<Long, UserGroupEntity>> r107 = r210.entrySet().iterator();     // Catch: Throwable -> L40
    L18:
        if (r107.hasNext() == false) goto L34;
        Map.Entry<Long, UserGroupEntity> r108 = r107.next();     // Catch: Throwable -> L40
        long r109 = r108.getKey().longValue();     // Catch: Throwable -> L40
        UserGroupEntity r110 = r108.getValue();     // Catch: Throwable -> L40
        if (r110.f253667id.longValue() > 0) goto L22;
    L24:
        boolean r111 = false;
    L25:
        if (r111 == false) goto L18;
        UserGroupEntity r112 = this.f411679d.get(Long.valueOf(r109));     // Catch: Throwable -> L40
        if (r112 == null) goto L30;
        if (r112.server_time.longValue() > r110.server_time.longValue()) goto L18;
        Iterator<Map.Entry<Long, UserGroupEntity>> r211 = r107;
        this.f411679d.put(Long.valueOf(r109), r110);     // Catch: Throwable -> L40
        r101.put(Long.valueOf(r109), r110);     // Catch: Throwable -> L40
        int r113 = c.f411684a;     // Catch: Throwable -> L40
        String r114 = "replace user group cache " + r109 + ", permission: " + r110.status + ", server time from " + r112.server_time + " to " + r110.server_time;     // Catch: Throwable -> L40
        Intrinsics.checkNotNullParameter("UserGroupService", "tag");     // Catch: Throwable -> L40
        Intrinsics.checkNotNullParameter(r114, "msg");     // Catch: Throwable -> L40
        Log.d("UserGroupService", "[UserGroup] " + r114);     // Catch: Throwable -> L40
        r107 = r211;
        goto L18
    L30:
        this.f411679d.put(Long.valueOf(r109), r110);     // Catch: Throwable -> L40
        r101.put(Long.valueOf(r109), r110);     // Catch: Throwable -> L40
        int r115 = c.f411684a;     // Catch: Throwable -> L40
        String r116 = "new user group cache " + r109 + ", permission: " + r110.status + ", server time " + r110.server_time;     // Catch: Throwable -> L40
        Intrinsics.checkNotNullParameter("UserGroupService", "tag");     // Catch: Throwable -> L40
        Intrinsics.checkNotNullParameter(r116, "msg");     // Catch: Throwable -> L40
        Log.d("UserGroupService", "[UserGroup] " + r116);     // Catch: Throwable -> L40
        goto L18
    L22:
        if (r110.server_time.longValue() <= 0) goto L24;
        r111 = true;
        goto L25
    L34:
        Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L40
        int r118 = 0;
    L36:
        if (r118 >= r104) goto L38;
        r103.lock();
        r118 = r118 + 1;
        goto L36
    L38:
        r106.unlock();
        this.f411678c.execute(new e(this, r101));
        return;
    L40:
        th = move-exception;
        int r119 = 0;
    L42:
        if (r119 >= r104) goto L44;
        r103.lock();
        r119 = r119 + 1;
        goto L42
    L44:
        r106.unlock();
        throw th;
    L11:
        r104 = 0;
        goto L12
    }

    @Override // a2b.o
    public final void w9(s.c r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        if (a() == true) goto L6;
        return;
    L6:
        if (this.f411680e.contains(r100) == true) goto L9;
        this.f411680e.put(r100, new Object());
        return;
    }

    @Override // a2b.o
    public final void z1(s.c r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        if (a() == true) goto L5;
        return;
    L5:
        this.f411680e.remove(r100);
    }

    @Inject
    public UserGroupService(l r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        Intrinsics.checkNotNullParameter(r101, "fgService");
        this.f411676a = r100;
        this.f411677b = r101;
        this.f411678c = PThreadExecutorsUtils.newSingleThreadExecutor(new n("thread-pool-user-group"));
        this.f411679d = new ConcurrentHashMap();
        this.f411680e = new ConcurrentHashMap();
        this.f411681f = new ReentrantReadWriteLock();
        this.f411682g = LazyKt.lazy(new UserGroupService$isFgEnabled$2(this));
    }

    @Override // a2b.o
    public final void H8(Context r100, AtUserGroupInfo r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "info");
        if (a() == true) goto L6;
        return;
    L6:
        if (r101.getPermissionStatus() != 2) goto L9;
        UDToast.show(r100, R.string.Lark_IM_NoPermissionViewUserGroup_Tooltip);
        return;
    L9:
        if (r101.getPermissionStatus() != 1) goto L13;
        ChatCoreModule.a().getProfileDependency().a(r100, String.valueOf(r101.getUserGroupId()), r101.getUserGroupName());
        return;
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [T, java.util.LinkedHashMap, java.util.Map] */
    @Override // a2b.o
    public final void c6(RichText r210, String r211) {
        Intrinsics.checkNotNullParameter(r210, "richText");
        if (a() == true) goto L6;
        return;
    L6:
        if (r210.getElements() != null) goto L8;
        return;
    L8:
        int r100 = c.f411684a;
        c.b("UserGroupService", "injectUserGroups to rich text, message id: " + r211);
        Iterator<Map.Entry<String, RichTextElement>> r101 = r210.getElements().getDictionary().entrySet().iterator();
    L10:
        if (r101.hasNext() == false) goto L83;
        Map.Entry<String, RichTextElement> r102 = r101.next();
        if (r102.getValue().getTag() != RichTextElement.RichTextTag.AT_USER_GROUP) goto L10;
        RichTextElement.AtUserGroupProperty r103 = (RichTextElement.AtUserGroupProperty) r102.getValue().getProperty();
        long r104 = r103.getUserGroupId();
        if (r104 == 0) goto L16;
        int r105 = c.f411684a;
        c.b("UserGroupService", "injectUserGroups, user group id: " + r104);
        if (a() == true) goto L20;
        UserGroupEntity r106 = null;
    L77:
        if (r106 == null) goto L78;
        Intrinsics.checkNotNull(r103);
        Intrinsics.checkNotNullParameter(r106, "<this>");
        Intrinsics.checkNotNullParameter(r103, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        r103.setDisplayName(r106.display_name);
        r103.setPermissionStatus(r106.status.intValue());
        goto L10
    L78:
        int r107 = c.f411684a;
        c.b("UserGroupService", "user group cache not found, id: " + r104);
        goto L10
    L20:
        List r108 = CollectionsKt.listOf(Long.valueOf(r104));
        Intrinsics.checkNotNullParameter(r108, "ids");
        if (a() == true) goto L23;
        Map r109 = MapsKt.emptyMap();
    L76:
        r106 = (UserGroupEntity) r109.get(Long.valueOf(r104));
        goto L77
    L23:
        c.b("UserGroupService", "getUserGroups: " + r108);
        ArrayList r110 = new ArrayList();
        Ref.ObjectRef r111 = new Ref.ObjectRef();
        ReentrantReadWriteLock.ReadLock r112 = this.f411681f.readLock();
        r112.lock();
        ArrayList r113 = new ArrayList();     // Catch: Throwable -> L80
        Iterator r114 = r108.iterator();     // Catch: Throwable -> L80
    L25:
        boolean r115 = true;
        if (r114.hasNext() == false) goto L64;
        long r116 = ((Number) r114.next()).longValue();     // Catch: Throwable -> L80
        UserGroupEntity r117 = this.f411679d.get(Long.valueOf(r116));     // Catch: Throwable -> L80
        if (r117 != null) goto L31;
        r110.add(Long.valueOf(r116));     // Catch: Throwable -> L80
    L48:
        r117 = null;
        long r118 = 0;
    L61:
        if (r117 == null) goto L25;
        r113.add(r117);     // Catch: Throwable -> L80
        goto L25
    L31:
        if ((System.currentTimeMillis() - r117.cache_time.longValue()) <= 86400000) goto L33;
        boolean r119 = true;
    L34:
        if (r119 == false) goto L55;
        r110.add(Long.valueOf(r116));     // Catch: Throwable -> L80
        ReentrantReadWriteLock r120 = this.f411681f;     // Catch: Throwable -> L80
        ReentrantReadWriteLock.ReadLock r121 = r120.readLock();     // Catch: Throwable -> L80
        if (r120.getWriteHoldCount() != 0) goto L38;
        int r122 = r120.getReadHoldCount();     // Catch: Throwable -> L80
    L39:
        int r123 = 0;
    L40:
        if (r123 >= r122) goto L42;
        r121.unlock();     // Catch: Throwable -> L80
        r123 = r123 + 1;     // Catch: Throwable -> L80
        goto L40
    L42:
        ReentrantReadWriteLock.WriteLock r124 = r120.writeLock();     // Catch: Throwable -> L80
        r124.lock();     // Catch: Throwable -> L80
        UserGroupEntity r125 = this.f411679d.remove(Long.valueOf(r116));     // Catch: Throwable -> L49
        int r126 = 0;
    L45:
        if (r126 >= r122) goto L47;
        r121.lock();     // Catch: Throwable -> L80
        r126 = r126 + 1;     // Catch: Throwable -> L80
        goto L45
    L47:
        r124.unlock();     // Catch: Throwable -> L80
        goto L48
    L49:
        th = move-exception;
        int r127 = 0;
    L51:
        if (r127 >= r122) goto L53;
        r121.lock();     // Catch: Throwable -> L80
        r127 = r127 + 1;     // Catch: Throwable -> L80
        goto L51
    L53:
        r124.unlock();     // Catch: Throwable -> L80
        throw th;     // Catch: Throwable -> L80
    L38:
        r122 = 0;
        goto L39
    L55:
        r118 = 0;
        if (r117.server_time.longValue() > 0) goto L59;
        r115 = false;
    L59:
        if (r115 == true) goto L61;
        r110.add(Long.valueOf(r116));     // Catch: Throwable -> L80
        goto L61
    L33:
        r119 = false;
        goto L34
    L64:
        ?? r128 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r113, 10)), 16));     // Catch: Throwable -> L80
        Iterator r129 = r113.iterator();     // Catch: Throwable -> L80
    L66:
        if (r129.hasNext() == false) goto L68;
        Object r130 = r129.next();     // Catch: Throwable -> L80
        r128.put(Long.valueOf(((UserGroupEntity) r130).f253667id.longValue()), r130);     // Catch: Throwable -> L80
        goto L66
    L68:
        r111.element = r128;     // Catch: Throwable -> L80
        Unit r131 = Unit.INSTANCE;     // Catch: Throwable -> L80
        r112.unlock();
        if ((!r110.isEmpty()) == true) goto L72;
    L75:
        r109 = (Map) r111.element;
        goto L76
    L72:
        if (r110.isEmpty() == true) goto L75;
        int r132 = c.f411684a;
        c.b("UserGroupService", "asyncPullMissedUserGroups, ids: " + r110);
        GetUserGroupEntitiesRequest.Builder r133 = new GetUserGroupEntitiesRequest.Builder();
        r133.user_group_ids(r110);
        r133.sync_data_strategy(SyncDataStrategy.TRY_LOCAL);
        t.g(this.f411676a.h(new com.bytedance.lark.rustclient.api.d(r133, GetUserGroupEntitiesResponse.ADAPTER, Command.GET_USER_GROUP_ENTITY_BY_IDS, null, null, null, null, 248)).a(), new UserGroupService$asyncPullMissedUserGroups$1(this), UserGroupService$asyncPullMissedUserGroups$2.INSTANCE);
    L80:
        th = move-exception;
        r112.unlock();
        throw th;
    L16:
        int r134 = c.f411684a;
        Intrinsics.checkNotNullParameter("UserGroupService", "tag");
        Intrinsics.checkNotNullParameter("invalid user group id", "msg");
        Log.e("UserGroupService", "[UserGroup] invalid user group id");
        goto L10
    }
}
