package com.obric.assistant.interaction.impl.essentialtask.task.migration;

import com.bytedance.keva.Keva;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.settings.ToggleName;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/task/migration/ObricHostDataMigrationUtil;", "", "<init>", "()V", "REPO_NAME", "", "TAG", "startMigration", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricHostDataMigrationUtil {
    public static final ObricHostDataMigrationUtil INSTANCE = null;
    private static final String REPO_NAME = "personal_context_toggles_state";
    private static final String TAG = "ObricHostDataMigrationUtil";

    static {
        INSTANCE = new ObricHostDataMigrationUtil();
    }

    private ObricHostDataMigrationUtil() {
    }

    public final boolean startMigration() {
        Keva r100 = Keva.getRepo(REPO_NAME, 0);
        Iterator r101 = CollectionsKt.listOf(new ToggleName[]{ToggleName.MAIN_TOGGLE, ToggleName.CALL_LOGS, ToggleName.CONTACTS, ToggleName.MESSAGE, ToggleName.CLOCK, ToggleName.NOTES, ToggleName.ALBUM, ToggleName.RECORD, ToggleName.CALENDAR, ToggleName.FILE_MANAGEMENT, ToggleName.MEMORY, ToggleName.ASSISTANT_ACTIVE_DATA, ToggleName.EVENT_MEMORY, ToggleName.COLLECTION_MEMORY, ToggleName.PERSONAL_INFO_MEMORY, ToggleName.SCREEN_MEMORY, ToggleName.AI_DIARY, ToggleName.HEARING_MEMORY}).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        String r102 = ((ToggleName) r101.next()).getToggleName();
        boolean r103 = r100.getBoolean(r102, true);
        FLogger.f375446a.i(TAG, "startMigration: key=" + r102 + ",value=" + r103);
        r100.storeBoolean(r102, r103);
        goto L4
    L6:
        return true;
    }
}
