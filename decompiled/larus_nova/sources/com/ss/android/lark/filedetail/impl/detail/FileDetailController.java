package com.ss.android.lark.filedetail.impl.detail;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.favorite.FavoriteMessageInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.filedetail.FileDetailModule;
import com.ss.android.lark.filedetail.dto.FileDetailLaunchParams;
import com.ss.android.lark.filedetailapi.container.IFileDetailPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class FileDetailController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f421564a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List<IFileDetailPlugin> f421565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static IFileDetailPlugin f421566c;

    static {
        f421564a = SetsKt.setOf(new String[]{"eml", "msg"});
        f421565b = new ArrayList();
    }

    public static boolean a(List r100) {
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Message r102 = (Message) r101.next();
        if (r102.isRecalled() == true) goto L9;
        if (r102.isSourceFileDelete() == false) goto L4;
        return false;
    L9:
        return false;
    L11:
        return true;
    }

    public static void c(FileDetailLaunchParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Context r101 = r100.getContext().get();
        if (r101 != null) goto L5;
        return;
    L5:
        Intent r102 = new Intent(r101, FileDetailActivity.class);
        r102.putExtra("extra.launch.params", r100);
        r101.startActivity(r102);
    }

    public static void d(final FileDetailLaunchParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        final UIGetDataCallback r101 = new UIGetDataCallback(new FileDetailController$openFileMessageDetail$1(r100));
        ArrayList r102 = new ArrayList();
        final ArrayList r103 = new ArrayList();
        Message r104 = r100.getMessage();
        boolean r105 = false;
        if (r104 != null) goto L5;
        r102.add(r100.getMessageId());
    L16:
        if (TextUtils.isEmpty(r100.getMergeMsgId()) == true) goto L18;
        r102.add(r100.getMergeMsgId());
    L18:
        FavoriteMessageInfo r106 = r100.getFavoriteMessage();
        if (r106 == null) goto L23;
        Message r107 = r106.getSourceMessage();
        if (r107 == null) goto L23;
        final String r108 = r107.getId();
    L24:
        if (r108 != null) goto L26;
    L27:
        r105 = true;
    L28:
        if (r105 == true) goto L33;
        if (r102.contains(r108) == true) goto L33;
        r102.add(r108);
    L33:
        if (CollectionUtils.isNotEmpty(r102) == false) goto L39;
        com.ss.android.lark.storage.a r109 = FileDetailModule.f421460a;
        hfb.b r110 = FileDetailModule.a.a();
        if (r110 == null) goto L41;
        hfb.b.d r111 = r110.getChatDependency();
        if (r111 == null) goto L42;
        new FileDetailController$checkParams$1(r108, r100, r103, r101);
        r111.a();
        return;
    L42:
        return;
    L41:
        return;
    L39:
        r101.onSuccess(Boolean.valueOf(a(r103)));
        return;
    L26:
        if (r108.length() != 0) goto L28;
    L23:
        r108 = null;
        goto L24
    L5:
        String r112 = r100.getSenderTenantId();
        if (r112 != null) goto L8;
    L11:
        boolean r113 = true;
    L12:
        if (r113 == false) goto L14;
        r100.setSenderTenantId(r104.getFromChatterTenantId());
    L14:
        r103.add(r104);
        goto L16
    L8:
        if (r112.length() == 0) goto L11;
        r113 = false;
        goto L12
    }

    public static String b(List r100, String r101) {
        if (r101 != null) goto L4;
    L7:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return null;
    L11:
        Iterator r103 = r100.iterator();
    L13:
        if (r103.hasNext() == false) goto L17;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(r101, ((Message) r104).getId()) == false) goto L13;
    L18:
        Message r105 = (Message) r104;
        if (r105 != null) goto L21;
        return null;
    L21:
        return r105.getFromChatterTenantId();
    L17:
        r104 = null;
        goto L18
    L4:
        if (r101.length() == 0) goto L7;
        r102 = false;
        goto L9
    }
}
