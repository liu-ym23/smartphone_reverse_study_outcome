package com.franmontiel.persistentcookiejar.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import okhttp3.g;

/* JADX INFO: loaded from: classes23.dex */
public class SetCookieCache implements CookieCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<IdentifiableCookie> f274228a;

    public class SetCookieCacheIterator implements Iterator<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<IdentifiableCookie> f274229a;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f274229a.hasNext();
        }

        @Override // java.util.Iterator
        public final g next() {
            return this.f274229a.next().f274227a;
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.f274229a.remove();
        }

        public SetCookieCacheIterator(SetCookieCache r100) {
            this.f274229a = ((HashSet) r100.f274228a).iterator();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator<g> iterator() {
        return new SetCookieCacheIterator(this);
    }

    public SetCookieCache() {
        this.f274228a = new HashSet();
    }

    @Override // com.franmontiel.persistentcookiejar.cache.CookieCache
    public final void addAll(Collection<g> r100) {
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<g> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(new IdentifiableCookie(r102.next()));
        goto L4
    L6:
        Iterator r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        IdentifiableCookie r104 = (IdentifiableCookie) r103.next();
        ((HashSet) this.f274228a).remove(r104);
        ((HashSet) this.f274228a).add(r104);
        goto L8
    }
}
