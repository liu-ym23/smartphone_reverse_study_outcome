package com.ss.android.lark.biz.im.api.extension.keyboard.inputstate;

import com.ss.android.lark.keyboard.event.q;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016j\u0002\b\u0005j\u0002\b\u0006¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/keyboard/inputstate/AudioPanelType;", "Lcom/ss/android/lark/keyboard/event/Notify;", "", "<init>", "(Ljava/lang/String;I)V", "OLD", "NEW", "getTag", "", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioPanelType extends Enum<AudioPanelType> implements q {
    public static final AudioPanelType NEW = null;
    public static final AudioPanelType OLD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioPanelType[] f410145a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410146b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f410147a = null;

        static {
            int[] r100 = new int[AudioPanelType.values().length];
            r100[AudioPanelType.OLD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[AudioPanelType.NEW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f410147a = r100;
        }
    }

    public static EnumEntries<AudioPanelType> getEntries() {
        return f410146b;
    }

    static {
        AudioPanelType r100 = new AudioPanelType("OLD", 0);
        OLD = r100;
        AudioPanelType r101 = new AudioPanelType("NEW", 1);
        NEW = r101;
        AudioPanelType[] r102 = {r100, r101};
        f410145a = r102;
        f410146b = EnumEntriesKt.enumEntries(r102);
    }

    public static AudioPanelType[] values() {
        return (AudioPanelType[]) f410145a.clone();
    }

    @Override // com.ss.android.lark.keyboard.event.c
    public String getTag() {
        int r100 = a.f410147a[ordinal()];
        if (r100 != 1) goto L5;
        return "old";
    L5:
        if (r100 != 2) goto L8;
        return "new";
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static AudioPanelType valueOf(String r100) {
        return (AudioPanelType) r27.a.a(AudioPanelType.class, r100);
    }

    public AudioPanelType(String r100, int r101) {
        super(r100, r101);
    }
}
