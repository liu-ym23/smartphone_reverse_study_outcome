package com.larus.bmhome.music.applet;

import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/music/applet/MusicAppletPage;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TEMPLATE_LIST", "TEMPLATE_DETAIL", "CHAT_MUSIC_DETAIL", "Companion", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MusicAppletPage extends Enum<MusicAppletPage> {
    public static final String APP_ID = "db_2c90E66";
    public static final MusicAppletPage CHAT_MUSIC_DETAIL = null;
    public static final a Companion = null;
    public static final String KEY_CONVERSATION_ID = "conversation_id";
    public static final String KEY_DATA_KEY = "data_key";
    public static final String KEY_INIT_PROGRESS = "init_progress";
    public static final String KEY_KEEP_FOREGROUND_AFTER_SEND = "keep_foreground_after_send";
    public static final String KEY_MESSAGE_ID = "message_id";
    public static final String KEY_MUSIC_CONTENT = "music_content";
    public static final String KEY_OUT_PULLING_FINISHED = "out_pulling_finished";
    public static final String KEY_PATH = "path";
    public static final String KEY_PLAYER_DATA = "music_player_data";
    public static final String KEY_REPLICA_PARAMS = "music_replica_params";
    public static final String KEY_SOURCE = "source";
    public static final String KEY_SOURCE_CREATION_SESSION_ID = "source_creation_session_id";
    public static final String QUERY_APP_ID = "app_id";
    public static final String ROUTE_DOUBAO_APPS = "sslocal://doubao_apps";
    public static final String ROUTE_MODE = "route_mode";
    public static final String ROUTE_MODE_NAVIGATION = "navigate";
    public static final String ROUTE_MODE_RELAUNCH = "relaunch";
    public static final String SOURCE_PROFILE_CREATION_DETAIL = "profile_creation_detail";
    public static final String SOURCE_TEMPLATE_LIST = "template_list";
    public static final MusicAppletPage TEMPLATE_DETAIL = null;
    public static final MusicAppletPage TEMPLATE_LIST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MusicAppletPage[] f312715a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f312716b = null;
    private final String value;

    public static final class a {
        public a() {
        }

        public final MusicAppletPage a(String r100, Bundle r101) {
            if (r101 == null) goto L6;
            String r102 = r101.getString("path");
            if (r102 == null) goto L6;
        L7:
            Iterator<MusicAppletPage> r103 = MusicAppletPage.getEntries().iterator();
        L9:
            if (r103.hasNext() == false) goto L13;
            MusicAppletPage r104 = r103.next();
            if (Intrinsics.areEqual(r104.getValue(), r102) == false) goto L9;
        L14:
            MusicAppletPage r105 = r104;
            if (r105 == null) goto L17;
            return r105;
        L17:
            return MusicAppletPage.TEMPLATE_LIST;
        L13:
            r104 = null;
        L6:
            r102 = query(r100, "path");
            goto L7
        }

        public final String query(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "key");
            Object r102 = null;
            if (r100 == null) goto L17;
            a r103 = MusicAppletPage.Companion;
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L7
            Object r105 = Result.m9449constructorimpl(UriProtector.getQueryParameter(UriProtector.parse(r100), r101));     // Catch: Throwable -> L7
        L10:
            if (Result.m9455isFailureimpl(r105) == true) goto L14;
            r102 = r105;
        L14:
            return (String) r102;
        L7:
            th = move-exception;
            Result.Companion r106 = Result.Companion;
            r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L10
        L17:
            return null;
        }
    }

    public static EnumEntries<MusicAppletPage> getEntries() {
        return f312716b;
    }

    static {
        MusicAppletPage r100 = new MusicAppletPage("TEMPLATE_LIST", 0, SOURCE_TEMPLATE_LIST);
        TEMPLATE_LIST = r100;
        MusicAppletPage r101 = new MusicAppletPage("TEMPLATE_DETAIL", 1, "template_detail");
        TEMPLATE_DETAIL = r101;
        MusicAppletPage r102 = new MusicAppletPage("CHAT_MUSIC_DETAIL", 2, "chat_music_detail");
        CHAT_MUSIC_DETAIL = r102;
        MusicAppletPage[] r103 = {r100, r101, r102};
        f312715a = r103;
        f312716b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static MusicAppletPage[] values() {
        return (MusicAppletPage[]) f312715a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static MusicAppletPage valueOf(String r100) {
        return (MusicAppletPage) r27.a.a(MusicAppletPage.class, r100);
    }

    public MusicAppletPage(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
