package com.larus.bmhome.taskskill.ui;

import com.larus.bmhome.taskskill.model.TaskSkill;
import com.larus.platform.model.SlashMentionConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class r {

    public static final class a extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f314587a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f314587a == ((a) r100).f314587a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f314587a;
        }

        public final String toString() {
            return "Loading(id=" + this.f314587a + ')';
        }

        public a(int r100) {
            this.f314587a = r100;
        }
    }

    public static final class b extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TaskSkill f314588a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f314588a, ((b) r100).f314588a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f314588a.hashCode();
        }

        public final String toString() {
            return "Skill(skill=" + this.f314588a + ')';
        }

        public b(TaskSkill r100) {
            Intrinsics.checkNotNullParameter(r100, SlashMentionConfig.SLASH_CONTENT_SKILL);
            this.f314588a = r100;
        }
    }

    public r() {
    }
}
