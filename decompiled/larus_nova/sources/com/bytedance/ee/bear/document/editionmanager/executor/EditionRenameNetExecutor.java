package com.bytedance.ee.bear.document.editionmanager.executor;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.Serializable;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes16.dex */
public final class EditionRenameNetExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService f219614a;

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

        public void setNames(LinkedList<String> r100) {
            this.names = r100;
        }
    }

    public static class a implements NetService.c<Result<Names>> {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.editionmanager.executor.EditionRenameNetExecutor$a$a, reason: collision with other inner class name */
        public class C3125a extends TypeToken<Result<Names>> {
            public C3125a() {
            }
        }

        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<Names> parse(String r100) throws NetService.ParseException {
            return (Result) GsonProtectorUtils.fromJson(new Gson(), r100, new C3125a().getType());
        }
    }

    public static class b implements NetService.c<Result> {
        public b() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r100) throws NetService.ParseException {
            return (Result) GsonProtectorUtils.fromJson(new Gson(), r100, Result.class);
        }
    }

    public EditionRenameNetExecutor(NetService r100) {
        this.f219614a = r100;
    }
}
