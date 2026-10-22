package com.bytedance.ee.bear.anniex;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes15.dex */
@Target({ElementType.PARAMETER})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/bear/anniex/ViewType;", "", "Companion", "docs-bitable-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface ViewType {
    public static final int AppDrawer = 6;
    public static final int BitableFeedCenter = 9;
    public static final int BitableFeedFilter = 10;
    public static final int BitableFeedSubscribe = 8;
    public static final int CalendarView = 2;
    public static final int ChooseBaseView = 17;
    public static final a Companion = null;
    public static final int EditorLinkTag = 7;
    public static final int HomePageSelectListPanel = 5;
    public static final int RecordView = 1;
    public static final int SearchConfig = 3;
    public static final int SuperAgentCardExpand = 14;
    public static final int SuperAgentConversationManager = 15;
    public static final int SuperAgentPanel = 13;
    public static final int SuperAgentSubConversation = 16;
    public static final int TextAiPolishPanel = 12;
    public static final int VoiceInputPanel = 11;
    public static final int WorkSpaceSearchPanel = 4;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f206228a = null;

        static {
            f206228a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f206228a;
    }
}
