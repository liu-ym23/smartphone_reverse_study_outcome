package com.ss.android.lark.contact.base.dependency;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.chat.api.IChatParser;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.contact.base.service.z;
import com.ss.android.lark.inv.export.router.InvRouter$InviteExternalPage$Param$From;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ContactBaseModuleDependency implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ContactBaseModuleDependency f418857b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f418858c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f418859a;

    @Override // com.ss.android.lark.contact.base.dependency.a
    public final IChatParser getChatParser() {
        return this.f418859a.getChatParser();
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public final boolean isSimpleTenant() {
        return this.f418859a.isSimpleTenant();
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public final boolean isSmallB() {
        return this.f418859a.isSmallB();
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public final void jumpInviteExternalPage(Context r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(InvRouter$InviteExternalPage$Param$From.CONTACT_EXTERNAL, "from");
        this.f418859a.jumpInviteExternalPage(r100, InvRouter$InviteExternalPage$Param$From.CONTACT_EXTERNAL, false);
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public final void jumpProfilePage(Context r100, Chatter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "chatter");
        this.f418859a.jumpProfilePage(r100, r101);
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public final void jumpProfilePage(Context r100, Object r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "profileObjOrId");
        this.f418859a.jumpProfilePage(r100, r101, r102);
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public final void jumpProfilePageForResult(Context r100, Fragment r101, Object r102, int r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "profileObjOrId");
        this.f418859a.jumpProfilePageForResult(r100, r101, r102, r110, 273);
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public final void openChatFromContactHomeByChatId(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "chatId");
        Intrinsics.checkNotNullParameter(r102, "fromTag");
        this.f418859a.openChatFromContactHomeByChatId(r100, r101, r102);
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public final void openCountrySelect(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f418859a.openCountrySelect(r100);
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public final void openCreateGroupChat(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f418859a.openCreateGroupChat(r100);
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public final void openInviteExternalActivityFromContact(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(InvRouter$InviteExternalPage$Param$From.CONTACT_NEW, "from");
        this.f418859a.openInviteExternalActivityFromContact(r100, InvRouter$InviteExternalPage$Param$From.CONTACT_NEW);
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public final void openUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f418859a.openUrl(r100);
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public final void startNewContactProfilePage(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "userId");
        Intrinsics.checkNotNullParameter(r102, "chatApplicationId");
        this.f418859a.startNewContactProfilePage(r100, r101, r102);
    }

    static {
        f418857b = new ContactBaseModuleDependency();
        f418858c = LazyKt.lazy(ContactBaseModuleDependency$defaultOfficeContactRepository$2.INSTANCE);
    }

    public static z a() {
        return (z) f418858c.getValue();
    }

    public ContactBaseModuleDependency() {
        this.f418859a = (a) ApiUtils.getApi(a.class);
    }
}
