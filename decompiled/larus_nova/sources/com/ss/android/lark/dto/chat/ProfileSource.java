package com.ss.android.lark.dto.chat;

import com.ss.android.lark.chat.entity.chatter.Chatter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ProfileSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f420560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f420561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f420562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f420563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Chatter.ChatterType f420564e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f420565f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f420566g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/dto/chat/ProfileSource$SourceChannel;", "", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface SourceChannel {
        public static final int CHAT = 0;
        public static final a Companion = null;
        public static final int FAVORITE = 6;
        public static final int MERGE_FORWARD = 2;
        public static final int REPLY_DETAIL = 1;
        public static final int REPLY_IN_THREAD = 7;
        public static final int THREAD = 3;
        public static final int THREAD_DETAIL = 4;
        public static final int THREAD_TAB = 5;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f420567a = null;

            static {
                f420567a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f420567a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/dto/chat/ProfileSource$SourceType;", "", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface SourceType {
        public static final int AVATAR = 0;
        public static final a Companion = null;
        public static final int FORWARD_PREVIEW = 6;
        public static final int MESSAGE = 1;
        public static final int PROFILE = 3;
        public static final int REACTION = 4;
        public static final int RECALL = 5;
        public static final int SYSTEM = 2;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f420568a = null;

            static {
                f420568a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f420568a;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f420569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f420570b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f420571c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f420572d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f420573e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f420574f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Chatter.ChatterType f420575g;

        public final ProfileSource a() {
            return new ProfileSource(this);
        }

        public a() {
            this.f420569a = 0;
            this.f420570b = 1;
            this.f420571c = null;
            this.f420572d = null;
            this.f420573e = null;
            this.f420574f = false;
            this.f420575g = null;
        }

        public a(ProfileSource r100) {
            Intrinsics.checkNotNullParameter(r100, "profileSource");
            this.f420569a = r100.f420560a;
            this.f420570b = r100.f420561b;
            this.f420571c = r100.f420565f;
            this.f420572d = r100.f420562c;
            this.f420573e = r100.f420563d;
            this.f420574f = r100.f420566g;
            this.f420575g = r100.f420564e;
        }
    }

    public ProfileSource(a r100) {
        this.f420560a = r100.f420569a;
        this.f420561b = r100.f420570b;
        this.f420562c = r100.f420572d;
        this.f420563d = r100.f420573e;
        this.f420564e = r100.f420575g;
        this.f420565f = r100.f420571c;
        this.f420566g = r100.f420574f;
    }
}
