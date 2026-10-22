package com.obric.assistant.settings;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/settings/ObricSettingsSubPageType;", "", "path", "", "allowNonDefaultAssistantEntry", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getPath", "()Ljava/lang/String;", "getAllowNonDefaultAssistantEntry", "()Z", "MEMORY_SETTINGS", "ACCESSARY_SETTINGS", "PRIVACY_MODEL_TRAINING", "VOICE_PRINT_MANAGEMENT", "OBRIC_ABOUT_APP", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricSettingsSubPageType extends Enum<ObricSettingsSubPageType> {
    public static final ObricSettingsSubPageType ACCESSARY_SETTINGS = null;
    public static final a Companion = null;
    public static final ObricSettingsSubPageType MEMORY_SETTINGS = null;
    public static final ObricSettingsSubPageType OBRIC_ABOUT_APP = null;
    public static final ObricSettingsSubPageType PRIVACY_MODEL_TRAINING = null;
    public static final ObricSettingsSubPageType VOICE_PRINT_MANAGEMENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricSettingsSubPageType[] f391743a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f391744b = null;
    private final boolean allowNonDefaultAssistantEntry;
    private final String path;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ObricSettingsSubPageType> getEntries() {
        return f391744b;
    }

    static {
        ObricSettingsSubPageType r100 = new ObricSettingsSubPageType("MEMORY_SETTINGS", 0, "memory_settings", false, 2, null);
        MEMORY_SETTINGS = r100;
        ObricSettingsSubPageType r101 = new ObricSettingsSubPageType("ACCESSARY_SETTINGS", 1, "accessary_settings", true);
        ACCESSARY_SETTINGS = r101;
        ObricSettingsSubPageType r102 = new ObricSettingsSubPageType("PRIVACY_MODEL_TRAINING", 2, "privacy_model_training", false, 2, null);
        PRIVACY_MODEL_TRAINING = r102;
        ObricSettingsSubPageType r103 = new ObricSettingsSubPageType("VOICE_PRINT_MANAGEMENT", 3, "voice_print_management", false, 2, null);
        VOICE_PRINT_MANAGEMENT = r103;
        ObricSettingsSubPageType r104 = new ObricSettingsSubPageType("OBRIC_ABOUT_APP", 4, "obric_about_app", false, 2, null);
        OBRIC_ABOUT_APP = r104;
        ObricSettingsSubPageType[] r105 = {r100, r101, r102, r103, r104};
        f391743a = r105;
        f391744b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static ObricSettingsSubPageType[] values() {
        return (ObricSettingsSubPageType[]) f391743a.clone();
    }

    public final boolean getAllowNonDefaultAssistantEntry() {
        return this.allowNonDefaultAssistantEntry;
    }

    public final String getPath() {
        return this.path;
    }

    public static ObricSettingsSubPageType valueOf(String r100) {
        return (ObricSettingsSubPageType) r27.a.a(ObricSettingsSubPageType.class, r100);
    }

    public ObricSettingsSubPageType(String r100, int r101, String r102, boolean r103) {
        super(r100, r101);
        this.path = r102;
        this.allowNonDefaultAssistantEntry = r103;
    }

    public /* synthetic */ ObricSettingsSubPageType(String r100, int r101, String r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = false;
    L5:
        this(r100, r101, r102, r103);
    }
}
