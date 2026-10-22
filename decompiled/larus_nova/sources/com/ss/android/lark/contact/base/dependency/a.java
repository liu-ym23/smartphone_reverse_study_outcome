package com.ss.android.lark.contact.base.dependency;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.chat.api.IChatParser;
import com.ss.android.lark.chat.entity.chatter.Chatter;

/* JADX INFO: loaded from: classes35.dex */
public interface a {
    IChatParser getChatParser();

    boolean isSimpleTenant();

    boolean isSmallB();

    void jumpInviteExternalPage(Context r100, String r101, boolean r102);

    void jumpProfilePage(Context r100, Chatter r101);

    void jumpProfilePage(Context r100, Object r101, int r102);

    void jumpProfilePageForResult(Context r100, Fragment r101, Object r102, int r103, int r104);

    void openChatFromContactHomeByChatId(Context r100, String r101, String r102);

    void openCountrySelect(Activity r100);

    void openCreateGroupChat(Context r100);

    void openInviteExternalActivityFromContact(Context r100, String r101);

    void openUrl(String r100);

    void startNewContactProfilePage(Context r100, String r101, String r102);
}
