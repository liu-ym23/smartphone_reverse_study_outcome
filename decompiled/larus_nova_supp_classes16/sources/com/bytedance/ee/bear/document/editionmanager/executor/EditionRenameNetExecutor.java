package com.bytedance.ee.bear.document.editionmanager.executor;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.Serializable;
import java.util.LinkedList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class EditionRenameNetExecutor {
    public final NetService a;

    public static class Names implements Serializable {
        private LinkedList<String> names;

        public Names() {
        }

        public String toString() {
            return "Names{names=" + this.names + '}';
        }

        public LinkedList<String> getNames() {
            return this.names;
        }

        public void setNames(LinkedList<String> r1) {
            this.names = r1;
        }
    }

    public static class a implements NetService.c<Result<Names>> {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.editionmanager.executor.EditionRenameNetExecutor$a$a, reason: collision with other inner class name */
        public class C0069a extends TypeToken<Result<Names>> {
            public C0069a() {
            }
        }

        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<Names> parse(String r3) throws NetService.ParseException {
            return (Result) GsonProtectorUtils.fromJson(new Gson(), r3, new C0069a().getType());
        }
    }

    public static class b implements NetService.c<Result> {
        public b() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r3) throws NetService.ParseException {
            return (Result) GsonProtectorUtils.fromJson(new Gson(), r3, Result.class);
        }
    }

    public EditionRenameNetExecutor(NetService r1) {
        this.a = r1;
    }
}
